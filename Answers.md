# These are the Answers
## Ensminger Lorentz Lab 8 

1. We need an explicit constructor because the min and max have to be able to move throughout the array
2. When you offer an boject, but the fixedArrayQueue is alread full, the boolean offer method will return
false and you will not be allowed to add anything to the queue. If the queue was not fixed we could impliment a
reallocate method to expand the queue allowing us to add another object.
3.Poll() will then return a null value since there are no values in the queue to pull out.
4. offer, peek, poll, isEmpty, and size are O(1). AsList is O(n).