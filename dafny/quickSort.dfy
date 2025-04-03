//-----------------------------------------------------------------------------
// Predicates
//-----------------------------------------------------------------------------

// La sequenza s è ordinata in ordine non decrescente.
predicate sorted(s: seq<int>)
{
  forall j, k :: 0 <= j <= k < |s| ==> s[j] <= s[k]
}

// s e t sono permutazioni l’una dell’altra.
predicate perm(s: seq<int>, t: seq<int>)
{
  multiset(s) == multiset(t)
}

//-----------------------------------------------------------------------------
// Methods
//-----------------------------------------------------------------------------

method quick_sort(arr: array<int>, start: int, end: int) 
    modifies arr
    requires 0 <= start < end < arr.Length
    ensures sorted(arr[..])
    // ensures sorted(arr[start..end+1]) //Ensure sorted subarray
    ensures perm(arr[..], old(arr[..]))
    decreases end - start
{
    //base case: (single element or empty array)
    if start >= end {
        return;
    }

    var pivot := partition(arr, start, end);
    assert 0 <= pivot < arr.Length; 
    assert start <= pivot <= end; //Check pivot position

        if pivot - 1 > start {
            assert 0 <= start < pivot <= end < arr.Length;
            quick_sort(arr, start, pivot - 1);
        }

        if pivot + 1 < end { 
            assert 0 <= pivot + 1 <= end < arr.Length;
            quick_sort(arr, pivot + 1, end);
        }

    assert perm(arr[..], old(arr[..]));
    assert sorted(arr[..]); //Check entire array
}

method partition(arr: array<int>, start: int, end: int) returns (pivot: int)
    modifies arr
    requires 0 <= start < end < arr.Length
    ensures start <= pivot <= end 
    ensures perm(arr[..], old(arr[..]))
{
    //Fissiamo il valore del pivot in una variabile costante.
    var pivotValue := arr[end]; //elemento a fine array 
    var i := start - 1;
    var j := start;

    while j < end 
        invariant start - 1 <= i < j <= end
        invariant i < arr.Length
        invariant perm(arr[..], old(arr[..]))
    { 
        if arr[j] <= pivotValue { 
            var aj := arr[j];
            i := i + 1; 
            assert i < arr.Length;
            swap(arr, i, j);
        }
        j := j + 1;
    }

    swap(arr, i + 1, end);
    pivot := i + 1;
    assert start <= pivot < arr.Length;
    return pivot;
}

method swap(arr: array<int>, i: int, j: int) 
    modifies arr
    requires 0 <= i <= j <  arr.Length
    ensures forall k: int :: 0 <= k < arr.Length && k != i && k != j ==> arr[k] == old(arr[k])
    ensures perm(arr[..], old(arr[..]))
{
    var temp := arr[i];
    arr[i] := arr[j];
    arr[j] := temp;
}
