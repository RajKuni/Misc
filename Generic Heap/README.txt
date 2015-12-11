This is a min/max heap. The code uses Java generics so heap can be used with any data type.

I created this heap implementation to get a better understanding generics and the heap data structure.

As a test, I used it to find kth ugly number.

You can instantiate the heap two ways:

Heap myHeap = new Heap(true); //Instantiates a min heap. Pass in "false" to instantiate max heap

Heap myHeap = new Heap(val, false); //Instantiates a max heap. The "val" parameter is an arraylist that initially
				    //populatest the heap. 


Also, a lot of the code may seem redundant/bad but I did this to learn! :)