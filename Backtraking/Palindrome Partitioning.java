import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // Main method to return all palindrome partitions
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    // Backtracking function to explore all partitions
    private static void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    // Choose
                    tempList.add(s.substring(start, i + 1));

                    // Explore
                    backtrack(result, tempList, s, i + 1);

                    // Un-choose (Backtrack)
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    // Function to check if the substring is a palindrome
    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    // Driver method
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);

        // Print the result
        System.out.println("All Palindrome Partitions for string \"" + s + "\": ");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
