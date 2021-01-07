# Heap Sort


wiki copy paste

The most direct competitor of quicksort is heapsort. Heapsort's worst-case running time is always O(n log n).
But, heapsort is assumed to be on average somewhat slower than standard in-place quicksort.
This is still debated and in research, with some publications indicating the opposite.[13][14]
Introsort is a variant of quicksort that switches to heapsort when a bad case is detected to avoid quicksort's worst-case running time.
If it is known in advance that heapsort is going to be necessary, using it directly will be faster than waiting for introsort to switch to it.