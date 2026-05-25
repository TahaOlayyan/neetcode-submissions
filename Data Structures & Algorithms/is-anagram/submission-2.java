  class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Integer> mapS = new HashMap<>();
            HashMap<Character, Integer> mapt = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
                mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
            }

            return mapS.equals(mapt);
        }

    }