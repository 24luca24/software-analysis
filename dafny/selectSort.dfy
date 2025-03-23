//The sequence is sorted in ascending order
predicate sorted(s: seq<int>)
{
  forall j, k :: 0 <= j <= k < |s| ==> s[j] <= s[k]
}

//s and t are permutation each other
predicate perm(s: seq<int>, t: seq<int>)
{
  multiset(s) == multiset(t)
}

method selectionSort(arr: array<int>) 
    modifies arr
    requires arr.Length > 0
    ensures perm(arr[..], old(arr[..]))
    ensures sorted(arr[..])
{
    var n := arr.Length;
    var i := 0;

    while i < n - 1
        invariant 0 <= i < arr.Length
        invariant forall k, l : int  :: 0 <= k < l < i ==> arr[k] <= arr[l] //Elements before i are sorted
        invariant forall k : int :: 0 <= k < i ==> forall j :: i <= j < n ==> arr[k] <= arr[j] //Elements before i are <= all elements in the rest
        invariant perm(arr[..], old(arr[..])) //The array remains a permutation of the original
    {
        var min := i; //Index of the smallest element
        var j := i + 1;

        while j < n
            invariant i + 1 <= j && j <= n
            invariant i <= min < n //min is within bounds
            invariant perm(arr[..], old(arr[..]))
            invariant forall k :: i <= k < j ==> arr[min] <= arr[k] //min points to the smallest element
        {
            if arr[min] > arr[j] {
                min := j; //Update the index of the smallest element
            }
            j := j + 1; //Increment j
        }

        //Swap the smallest element with the current element if needed
        if min != i {
            var temp := arr[min];
            arr[min] := arr[i];
            arr[i] := temp;
        }

        i := i + 1; //Increment i
    }
}