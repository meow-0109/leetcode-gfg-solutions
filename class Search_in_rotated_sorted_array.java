class Search_in_rotated_sorted_array {
    int search(int[] arr, int key) {
        // Initialize the search space (start and end pointers)
        int start = 0;
        int end = arr.length - 1;

        // Keep searching while the search space is valid
        while (start <= end) {
            // Find the middle element
            int mid = start + (end - start) / 2;

            // If the middle element is the target, return its index
            if (arr[mid] == key) {
                return mid;
            }

            // Check which half is sorted
            if (arr[start] <= arr[mid]) {
                // Left half is sorted
                if (arr[start] <= key && key < arr[mid]) {
                    // If key lies within the sorted left half
                    end = mid - 1;
                } else {
                    // Otherwise, search in the right half
                    start = mid + 1;
                }
            } else {
                // Right half is sorted
                if (arr[mid] < key && key <= arr[end]) {
                    // If key lies within the sorted right half
                    start = mid + 1;
                } else {
                    // Otherwise, search in the left half
                    end = mid - 1;
                }
            }
        }

        // If not found, return -1
        return -1;
    }
}
