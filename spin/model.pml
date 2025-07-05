//number of task 
#define N_TASKS 3

//if you uncomment the next line, the tasks will be executed in order
//#define ORDERED

//array to keep track of done tasks
bit done[N_TASKS] = 0;

//variable to keep track of the next task to be executed
int next_task = 0;

//ordered execution
#ifdef ORDERED
proctype task_runner(int id) {
    do
    :: (!done[id] && id == next_task) ->
        atomic {
            done[id] = 1;

            //update to next task in order
            next_task = (id + 1) % N_TASKS;
        }
        break;
    od
}

#else
proctype task_runner(int id) {
    byte k;
    bool pending;

    do
    :: (done[id] == 0 && id == next_task) ->
        atomic {
           done[id] = 1;

        // Check if there are any remaining tasks
        pending = false;
        k = 0;
        do
        :: (k < N_TASKS) ->
            if
            :: done[k] == 0 -> pending = true; break;
            :: else -> k++
            fi
        :: else -> break;
        od;

        if
        :: !pending -> break;
        :: else ->
            //nondeterministically pick next task among the unfinished ones
            if
            :: (!done[0]) -> next_task = 0;
            :: (!done[1]) -> next_task = 1;
            :: (!done[2]) -> next_task = 2;
            fi;
        fi
        }
        if
        :: !pending -> break;
        :: else -> skip;
        fi;
    od
}
#endif

//launch all workers
init {
    atomic {
            int i = 0;
    do
    :: (i < N_TASKS) -> run task_runner(i); i++
    :: else -> break
    od;
    }
}

//to see more info about the ltl properties go on the report, there is a section dedicated
#if N_TASKS == 3
ltl p1 { <> done[0] && <> done[1] && <> done[2]}

ltl p2 {
    [] ((done[0] && done[1] && done[2]) -> done[0]) 
    }

ltl p3 { 
    [] (done[0] -> [](done[0])) &&
    [] (done[1] -> [](done[1])) &&
    [] (done[2] -> [](done[2]))
    }

ltl p4 {
    [] !(done[0] && done[1])
}
#endif

#if N_TASKS == 4
ltl p1 { <> done[0] && <> done[1] && <> done[2] && <> done[3]}

ltl p2 {
    [] ((done[0] && done[1] && done[2] && done[3]) -> done[0]) 
    }

ltl p3 { 
    [] (done[0] -> [](done[0])) &&
    [] (done[1] -> [](done[1])) &&
    [] (done[2] -> [](done[2])) &&
    [] (done[3] -> [](done[3]))
    }

ltl p4 {
    [] !(done[0] && done[1])
}
#endif

#if N_TASKS == 5
ltl p1 { <> done[0] && <> done[1] && <> done[2] && <> done[3] && <> done[4]}

ltl p2 {
    [] ((done[0] && done[1] && done[2] && done[3] && done[4]) -> done[0]) 
    }

ltl p3 { 
    [] (done[0] -> [](done[0])) &&
    [] (done[1] -> [](done[1])) &&
    [] (done[2] -> [](done[2])) &&
    [] (done[3] -> [](done[3])) &&
    [] (done[4] -> [](done[4])) 
    }

ltl p4 {
    [] !(done[0] && done[1])
}
#endif

#if N_TASKS == 10
ltl p1 { <> done[0] && <> done[1] && <> done[2] && <> done[3] && <> done[4] && <> done[5] && <> done[6] && <> done[7] && <> done[8] && <> done[9]}

ltl p2 {
    [] ((done[0] && done[1] && done[2] && done[3] && done[4] && done[5] && done[6] && done[7] && done[8] && done[9]) -> done[0]) 
    }

ltl p3 { 
    [] (done[0] -> [](done[0])) &&
    [] (done[1] -> [](done[1])) &&
    [] (done[2] -> [](done[2])) &&
    [] (done[3] -> [](done[3])) &&
    [] (done[4] -> [](done[4])) &&
    [] (done[5] -> [](done[5])) &&
    [] (done[6] -> [](done[6])) &&
    [] (done[7] -> [](done[7])) &&
    [] (done[8] -> [](done[8])) &&
    [] (done[9] -> [](done[9])) 
    }

ltl p4 {
    [] !(done[0] && done[1])
}
#endif

