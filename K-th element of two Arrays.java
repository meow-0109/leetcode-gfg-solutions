class Solution {
    public int kthElement(int a[], int b[], int k) {
        // Two pointers for both arrays
        int i = 0, j = 0;
        // To count how many elements have been considered so far
        int count = 0;

        // Merge process (like in merge sort) until one array ends
        while (i < a.length && j < b.length) {
            int val;

            // Pick the smaller element from a[i] and b[j]
            if (a[i] < b[j]) {
                val = a[i];
                i++; // move pointer in array a
            } else {
                val = b[j];
                j++; // move pointer in array b
            }

            count++; // one element has been taken

            // If we have reached the k-th element, return it
            if (count == k) {
                return val;
            }
        }

        // If some elements are still left in array a
        while (i < a.length) {
            count++;
            if (count == k) {
                return a[i]; // found the k-th element
            }
            i++;
        }

        // If some elements are still left in array b
        while (j < b.length) {
            count++;
            if (count == k) {
                return b[j]; // found the k-th element
            }
            j++;
        }

        // If k is larger than total elements (invalid case)
        return -1;
    }
}
