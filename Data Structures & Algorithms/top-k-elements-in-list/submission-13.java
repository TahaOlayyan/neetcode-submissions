class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> freqmap = new HashMap<>();

            for (int num : nums) {
                freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);
            }

            List<Integer>[] bucket = new List[nums.length + 1];

            for (int key : freqmap.keySet()) {
                int freq = freqmap.get(key);
                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }
            int[] res = new int[k];
            int count = 0;

            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] != null) {
                    for (int index : bucket[i]) {
                        res[count++] = index;

                        if (count == k) {
                            return res;
                        }
                    }
                }
            }
            return res;
        }
    }