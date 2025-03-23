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

// Se si scambiano gli elementi agli indici i e j in s per ottenere t,
// oppure se i == j (nessun cambiamento) oppure solo s[i] e s[j] vengono scambiati.
predicate swapped(s: seq<int>, t: seq<int>, i: int, j: int)
{
  0 <= i < |s| && 0 <= j < |s| &&
  (
    (i == j ==> s == t) ||
    (i != j && s[i] == t[j] && s[j] == t[i] &&
      (forall k :: 0 <= k < |s| && k != i && k != j ==> s[k] == t[k]))
  )
}

//-----------------------------------------------------------------------------
// Methods
//-----------------------------------------------------------------------------

method quick_sort(arr: array<int>, start: int, end: int) 
    modifies arr
    //requires arr.Length > 0 //not necessary
    requires 0 <= start <= end < arr.Length
    
    //ensures sorted(arr[..])
    ensures sorted(arr[start..end+1]) // Ensure sorted subarray
    ensures perm(arr[..], old(arr[..]))
    decreases end - start
{
    
    if start < end { //when there is only one element, then start = end (when one element is left in the array) -> start == end
        var pivot := partition(arr, start, end);
        assert 0 < pivot <= end < arr.Length; //o assume 
        if pivot > start {
            assert 0 <= start <= pivot - 1 < arr.Length;
            quick_sort(arr, start, pivot - 1);
        }
        if pivot < end {
            assert 0 <= pivot + 1 <= end < arr.Length;
            quick_sort(arr, pivot + 1, end);
        }
        assert sorted(arr[..]); //might not hold
        assert perm(arr[..], old(arr[..]));
    }
}

method partition(arr: array<int>, start: int, end: int) returns (pivot: int)
    modifies arr
    //require the length of the subarray to be > 0
    // requires |arr[start..end]| > 0 //check correctness
    requires 0 <= start <= end < arr.Length 
    // ensures start <= pivot <= end 
    // ensures forall i: int :: start <= i < pivot ==> arr[i] <= arr[pivot]
    // ensures forall j: int :: pivot < j <= end ==> arr[j] >= arr[pivot]
    ensures perm(arr[..], old(arr[..]))
{
    // Fissiamo il valore del pivot in una variabile costante.
    var pivotValue := arr[end]; //elemento a fine array 
    var i := start - 1;
    var j := start;

    while j < end 
        invariant start - 1 <= i <= j <= end
        invariant perm(arr[..], old(arr[..]))
        invariant start - 1 <= i <= j <= end //i can be equal to j
        invariant forall k :: start <= k <= i ==> arr[k] <= pivotValue
        invariant forall k :: i < k < j ==> arr[k] > pivotValue

        // invariant exists k: int :: i < k < j ==> arr[k] > pivotValue
        
    { 
        if arr[j] <= pivotValue { 
            var aj := arr[j];
            i := i + 1; 
            swap(arr, i, j);
            assert arr[i] == aj; // helps Dafny realize what we just put at arr[i]
            assert arr[i] <= pivotValue;

        }
        j := j + 1;
    }

    swap(arr, i + 1, end);
    pivot := i + 1;
    return pivot;
}

method swap(arr: array<int>, i: int, j: int) 
    modifies arr
    requires 0 <= i < arr.Length
    requires 0 <= j < arr.Length
    ensures forall k: int :: 0 <= k < arr.Length && k != i && k != j ==> arr[k] == old(arr[k])
    ensures perm(arr[..], old(arr[..]))
    ensures swapped(old(arr[..]), arr[..], i, j)
{
    var temp := arr[i];
    arr[i] := arr[j];
    arr[j] := temp;
}

// method swap(a: array<int>, i: int, j: int)
//     modifies a
//     requires 0 <= i < a.Length
//     requires 0 <= j < a.Length
//     ensures a[i] == old(a[j])
//     ensures a[j] == old(a[i])
//     ensures forall k: int :: 0 <= k < a.Length && k != i && k != j ==> a[k] == old(a[k])
//     ensures perm(a[..], old(a[..]))
// {
//     a[i], a[j] == a[j], a[i];
// }