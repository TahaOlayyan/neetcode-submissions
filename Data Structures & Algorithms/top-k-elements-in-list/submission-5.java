class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // 2. بنجهز مصفوفة الـ Buckets
            // حجمها nums.length + 1 لأنه أقصى تكرار ممكن هو حجم المصفوفة الأصلية
            List<Integer>[] buckets = new List[nums.length + 1];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new ArrayList<>();
            }

            // 3. بنعبي الـ Buckets: الـ Index هو التكرار، والقيمة هي الرقم
            for (int key : freqMap.keySet()) {
                int freq = freqMap.get(key);
                buckets[freq].add(key);
            }

            // 4. بنمشي من آخر المصفوفة (أعلى تكرار) وبنسحب K عناصر
            int[] result = new int[k];
            int counter = 0;

            for (int i = buckets.length - 1; i >= 0; i--) {
                // إذا الـ Bucket مش فاضي، بنسحب الأرقام اللي فيه
                for (int num : buckets[i]) {
                    result[counter++] = num;
                    // بس نوصل للعدد المطلوب k، بنوقف وبنرجع الجواب
                    if (counter == k) {
                        return result;
                    }
                }
            }

            return result;
        }
    }