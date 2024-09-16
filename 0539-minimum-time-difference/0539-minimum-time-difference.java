class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            String[] str = timePoints.get(i).split(":");
            time[i] = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        }

        Arrays.sort(time);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, time[i] - time[i - 1]);
        }
        return Math.min(min, Math.abs(time[n - 1] - (time[0] + 1440)));
    }
}