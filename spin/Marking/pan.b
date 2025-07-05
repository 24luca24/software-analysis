	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* CLAIM p4 */
;
		
	case 3: // STATE 1
		goto R999;

	case 4: // STATE 10
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM p3 */
;
		
	case 5: // STATE 1
		goto R999;
;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		
	case 16: // STATE 29
		goto R999;
;
		
	case 17: // STATE 37
		goto R999;
;
		
	case 18: // STATE 45
		goto R999;
;
		
	case 19: // STATE 53
		goto R999;
;
		
	case 20: // STATE 61
		goto R999;
;
		
	case 21: // STATE 69
		goto R999;
;
		
	case 22: // STATE 77
		goto R999;
;
		
	case 23: // STATE 85
		goto R999;
;
		
	case 24: // STATE 93
		goto R999;
;
		
	case 25: // STATE 101
		goto R999;

	case 26: // STATE 110
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM p2 */
;
		
	case 27: // STATE 1
		goto R999;

	case 28: // STATE 10
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM p1 */
;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		;
		
	case 49: // STATE 74
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC :init: */

	case 50: // STATE 1
		;
		((P1 *)_this)->_2_1_i = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 52: // STATE 3
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 53: // STATE 4
		;
		((P1 *)_this)->_2_1_i = trpt->bup.oval;
		;
		goto R999;

	case 54: // STATE 11
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC task_runner */
;
		;
		
	case 56: // STATE 2
		;
		now.done[ Index(((P0 *)_this)->id, 10) ] = trpt->bup.oval;
		;
		goto R999;

	case 57: // STATE 4
		;
		((P0 *)_this)->k = trpt->bup.ovals[1];
		((P0 *)_this)->pending_tasks = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		;
		
	case 59: // STATE 6
		;
	/* 0 */	((P0 *)_this)->k = trpt->bup.oval;
		;
		;
		goto R999;

	case 60: // STATE 7
		;
		((P0 *)_this)->pending_tasks = trpt->bup.oval;
		;
		goto R999;

	case 61: // STATE 10
		;
		((P0 *)_this)->k = trpt->bup.oval;
		;
		goto R999;

	case 62: // STATE 18
		;
	/* 0 */	((P0 *)_this)->pending_tasks = trpt->bup.oval;
		;
		;
		goto R999;

	case 63: // STATE 21
		;
		((P0 *)_this)->next = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 65: // STATE 23
		;
		now.next_task = trpt->bup.oval;
		;
		goto R999;

	case 66: // STATE 26
		;
		((P0 *)_this)->next = trpt->bup.oval;
		;
		goto R999;

	case 67: // STATE 35
		;
		p_restor(II);
		;
		;
		goto R999;
	}

