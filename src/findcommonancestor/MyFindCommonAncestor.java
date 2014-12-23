package findcommonancestor;

import java.util.*;

/**
 * Created by Illia on 22.12.2014.
 */
public class MyFindCommonAncestor implements FindCommonAncestor {

    /**
     * O(n*m) where m - number of branches merged into current branches
     * its possible to do that in 1 step, not in m steps. But it requires a lot more coding, so I've just used Set to skip duplicates
     * @param commitHashes
     * @param parentHashes
     * @param commitHash1
     * @param commitHash2
     * @return
     */
    @Override
    public String findCommonAncestor(String[] commitHashes, String[][] parentHashes, String commitHash1, String commitHash2) {

        // now build set of all commits for each given commit
        Set<String> graph1 = new HashSet<String>();
        Set<String> graph2 = new HashSet<String>();

        // O(n*m)
        // where m - number of branches merged into current branches
        // its possible to do that in 1 step, not in m steps. But it requires a lot more coding, so I've just used Set
        // to skip duplicates
        String suddenlyFoundThatOneCommitIsAncestorOfOther = fillSetsOfCommits(commitHashes, parentHashes, commitHash1,
                commitHash2, graph1, graph2);

        if (suddenlyFoundThatOneCommitIsAncestorOfOther != null) {
            return suddenlyFoundThatOneCommitIsAncestorOfOther;
        }

        // O(n)
        Set<String> commonAncestorsInSortedOrder = processParents(parentHashes);
        // now we know what commits are the merges of 2 graphs

        // O(n)
        for (String parent : commonAncestorsInSortedOrder) {
            if (graph1.contains(parent) && graph2.contains(parent)) {
                return parent;
            }
        }

        return null;
    }

    private String fillSetsOfCommits(String[] commitHashes, String[][] parentHashes, String commitHash1,
                                     String commitHash2, Set<String> graph1, Set<String> graph2) {
        boolean hashOneProcessed = false;
        boolean hashTwoProcessed = false;

        for (int i = 0; i < commitHashes.length; i++) {
            String commitHash = commitHashes[i];

            if (!hashOneProcessed && commitHash.equals(commitHash1)) {
                String suddenlyItIsAncestorOfHash2 = fillGraph(commitHashes, parentHashes, graph1, i, commitHash2);
                if (suddenlyItIsAncestorOfHash2 != null)
                    return suddenlyItIsAncestorOfHash2;

                hashOneProcessed = true;
            } else if (!hashTwoProcessed && commitHash.equals(commitHash2)) {
                String suddenlyItIsAncestorOfHash1 = fillGraph(commitHashes, parentHashes, graph2, i, commitHash1);
                if (suddenlyItIsAncestorOfHash1 != null)
                    return suddenlyItIsAncestorOfHash1;

                hashTwoProcessed = true;
            }
        }

        return null;
    }

    private String fillGraph(String[] commitHashes, String[][] parentHashes, Set<String> graph, int currentStartIdx,
                             String commitToFind) {
        Integer ancestorIdx = currentStartIdx;

        while (true) {
            String currentCommitHash = commitHashes[ancestorIdx];
            if (currentCommitHash.equals(commitToFind)) return commitToFind;

            graph.add(currentCommitHash);

            String[] ancestorHashes = parentHashes[ancestorIdx];
            if (ancestorHashes == null) {
                break;
            } else if (ancestorHashes.length == 1) {
                // if {C}
                String ancestorHash = ancestorHashes[0];
                ancestorIdx = getNextCommitOfAncestor(commitHashes, ancestorIdx, ancestorHash);
            } else {
                // if {D,F}
                // then merge branches

                Integer branch1Ancestor = getNextCommitOfAncestor(commitHashes, ancestorIdx, ancestorHashes[0]);
                String suddenlyFoundResult = fillGraph(commitHashes, parentHashes, graph, branch1Ancestor, commitToFind);

                if (suddenlyFoundResult != null) {
                    return suddenlyFoundResult;
                }

                Integer branch2Ancestor = getNextCommitOfAncestor(commitHashes, ancestorIdx, ancestorHashes[1]);
                suddenlyFoundResult = fillGraph(commitHashes, parentHashes, graph, branch2Ancestor, commitToFind);

                if (suddenlyFoundResult != null) {
                    return suddenlyFoundResult;
                }

                break;
            }
        }

        return null;
    }

    private Integer getNextCommitOfAncestor(String[] commitHashes, Integer searchFromIdx, String ancestorHash) {
        for (int c = searchFromIdx + 1; c < commitHashes.length; c++) {
            String commitHash = commitHashes[c];
            if (ancestorHash.equals(commitHash)) {
                return c;
            }
        }
        return -1;
    }

    private Set<String> processParents(String[][] parentHashes) {
        Map<String, Integer> partialResult = new LinkedHashMap<String, Integer>();

        // -1 = till the null value
        // O(n)
        for (int i = 0; i < parentHashes.length - 1; i++) {
            String[] hashArr = parentHashes[i];

            if (hashArr.length == 1) {
                String hash = hashArr[0];
                incrementHashParentsCount(partialResult, hash);
            }
        }

        Set<String> result = new LinkedHashSet<String>();

        // O(n)
        for (Map.Entry<String, Integer> entry : partialResult.entrySet()) {
            if (entry.getValue() > 1) result.add(entry.getKey());
        }

        return result;
    }

    private void incrementHashParentsCount(Map<String, Integer> result, String hash) {
        // O(1)
        Integer count = result.get(hash);
        if (count == null) count = 0;

        result.put(hash, count + 1);
    }

}
