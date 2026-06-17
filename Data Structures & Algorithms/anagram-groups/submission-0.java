class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();

            for (String word : strs) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);

                map.putIfAbsent(new String(chars), new ArrayList<>());
                map.get(new String(chars)).add(word);

            }
            return new ArrayList<>(map.values());
        }
    }