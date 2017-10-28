package drozd.dawid.dexode.com.secureme;

/**
 * Created by gelldur on 25.10.17.
 */
public class SecuredData implements Secured {

    /// My secret algorithm implementation
    @Override
    public void sort(int[] array) {
        this._numbers = array;
        _count = array.length;
        this._helper = new int[_count];
        mergesort(0, _count - 1);
    }

    /// My secret algorithm implementation
    private void mergesort(final int leftIndex, final int rightIndex) {
        // check if leftIndex is smaller than rightIndex, if not then the array is sorted
        if (leftIndex >= rightIndex) {
            return;
        }

        // Get the index of the element which is in the middle
        int middle = leftIndex + (rightIndex - leftIndex) / 2;
        // Sort the left side of the array
        mergesort(leftIndex, middle);
        // Sort the right side of the array
        mergesort(middle + 1, rightIndex);
        // Combine them both
        merge(leftIndex, middle, rightIndex);
    }

    /// My secret algorithm implementation
    private void merge(int leftIndex, int middle, int rightIndex) {
        // Copy both parts into the _helper array
        for (int i = leftIndex; i <= rightIndex; ++i) {
            _helper[i] = _numbers[i];
        }

        int i = leftIndex;
        int j = middle + 1;
        int k = leftIndex;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= rightIndex) {
            if (_helper[i] <= _helper[j]) {
                _numbers[k] = _helper[i];
                ++i;
            } else {
                _numbers[k] = _helper[j];
                ++j;
            }
            ++k;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            _numbers[k] = _helper[i];
            ++k;
            ++i;
        }
    }

    @Override
    public String getPassword() {
        return _password;
    }

    ///My secret field
    private static final String _password = "my_secret_password";

    private int[] _numbers;
    private int[] _helper;

    private int _count;
}
