

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        if (s == null || s.length() == 0) return partitions;

        // Step 1: Record the last occurrence index of each character
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        // Step 2: Greedily expand the partition window
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            end = Math.max(end, lastOccurrence.get(curr));

            // When we reach the furthest reachable index, close the partition
            if (i == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }

        return partitions;
    }
}