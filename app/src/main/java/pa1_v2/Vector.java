package pa1_v2;

/**
 * Vector class represents a vector in n-dimensional space with basic operations.
 */
public class Vector {

    // Attributes
    private int n;
    private int[] data;

    /**
     * Constructor to initialize the Vector with the specified number of 
     * dimensions (n) and sets all elements to -1.
     * @param n The number of dimensions of the vector.
     */
    public Vector(int n) {
        this.n = n;
        this.data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -1;
        }
    }

    /**
     * Get the number of dimensions of the vector.
     * @return The number of dimensions.
     */
    public int getDimension() {
        return this.n;
    }

    /**
     * Get the element at the specified index in the vector.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    public int read(int index) {
        return this.data[index];
    }

    /**
     * Set the element at the specified index in the vector to the given value.
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        this.data[index] = value;
    }

    /**
     * Remove the element at the specified index in the vector.
     * @param index The index of the element to remove.
     */
    public void delete(int index) {
        
        for (int i=index; i<n-1; i++){
            this.data[i] = this.data[i+1];
        }
        this.data[n-1] = -1;
        
    }

    /**
     * Add the elements of the given vector v to the current vector.
     * The vectors must have the same number of dimensions.
     * @param v The vector to add.
     */
    public void add(Vector v) {
        for (int i = 0; i < n; i++){
            this.data[i] += v.data[i];
        }
        
        
    }

    /**
     * Subtract the elements of the given vector v from the current vector.
     * @param v
     */
    public void subtract(Vector v) {
        for (int i = 0; i < n; i++){
            this.data[i] -= v.data[i];
        }
        
    }

    /**
     * Get the maximum element in the vector.
     * @return The maximum element.
     */
    public int max() {
        int max_val;
        max_val = this.data[0];
        for (int i = 0; i < n; i++) {
            if (this.data[i] > max_val) {
                max_val = this.data[i];
            }
        }
        return max_val;
    }

    /**
     * Get the minimum element in the vector.
     * @return The minimum element.
     */
    public int min() {
        int min_val;
        min_val = this.data[0];
        for (int i = 0; i < n; i++) {
            if (this.data[i] < min_val) {
                min_val = this.data[i];
            }
        }
        return min_val;
    }

    /**
     * Get the average of all elements in the vector.
     * @return The average of all elements.
     */
    public double average() {
        int averg; 
        averg = 0;
        for (int i = 0; i < n; i++){
            averg += this.data[i];
        
        }
        averg = averg/n;
        return averg;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int search(int value) {
        int search_index;
        search_index = -1;
        for (int i = 0; i < n; i++){
            if (this.data[i] == value){
                search_index = i;
            }
        }
        return search_index;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * This method is optimized for speed using the Binary Search Algorithm.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int searchFast(int value) {
        int upper = this.n-1;
        int lower = 0;
        int mid;
        
        while (lower <= upper){
            mid = Math.round((lower + upper)/2);
            if (data[mid] == value){
                return mid;
            }
            else if (data[mid] < value){
                lower = mid + 1;
            }
            else if (data[mid] > value){
                upper = mid + 1;
            }
            
        }
        return -1;

        

    }

    /**
     * Sort the elements of the vector in ascending order.
     */
    public void sort() {
        for (int i =0; i < n - 1; i++){
            for (int j = 0; j < n - 1; j++){
                if (data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
    
}
