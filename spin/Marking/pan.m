#define rand	pan_rand
#define pthread_equal(a,b)	((a)==(b))
#if defined(HAS_CODE) && defined(VERBOSE)
	#ifdef BFS_PAR
		bfs_printf("Pr: %d Tr: %d\n", II, t->forw);
	#else
		cpu_printf("Pr: %d Tr: %d\n", II, t->forw);
	#endif
#endif
	switch (t->forw) {
	default: Uerror("bad forward move");
	case 0:	/* if without executable clauses */
		continue;
	case 1: /* generic 'goto' or 'skip' */
		IfNotBlocked
		_m = 3; goto P999;
	case 2: /* generic 'else' */
		IfNotBlocked
		if (trpt->o_pm&1) continue;
		_m = 3; goto P999;

		 /* CLAIM p4 */
	case 3: // STATE 1 - _spin_nvr.tmp:147 - [(!(!((done[0]&&done[1]))))] (6:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[5][1] = 1;
		if (!( !( !((((int)now.done[0])&&((int)now.done[1]))))))
			continue;
		/* merge: assert(!(!(!((done[0]&&done[1])))))(0, 2, 6) */
		reached[5][2] = 1;
		spin_assert( !( !( !((((int)now.done[0])&&((int)now.done[1]))))), " !( !( !((done[0]&&done[1]))))", II, tt, t);
		/* merge: .(goto)(0, 7, 6) */
		reached[5][7] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 4: // STATE 10 - _spin_nvr.tmp:152 - [-end-] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[5][10] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* CLAIM p3 */
	case 5: // STATE 1 - _spin_nvr.tmp:78 - [(((!(!(done[0]))&&!(done[0]))||((!(!(done[1]))&&!(done[1]))||((!(!(done[2]))&&!(done[2]))||((!(!(done[3]))&&!(done[3]))||((!(!(done[4]))&&!(done[4]))||((!(!(done[5]))&&!(done[5]))||((((((!(!(done[8]))&&!(done[8]))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(((((!(!(done[9]))&&!(done[9]))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||((((!(!(done[7]))&&!(done[7]))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(!(!(done[6]))&&!(done[6]))))))))))))] (26:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][1] = 1;
		if (!((( !( !(((int)now.done[0])))&& !(((int)now.done[0])))||(( !( !(((int)now.done[1])))&& !(((int)now.done[1])))||(( !( !(((int)now.done[2])))&& !(((int)now.done[2])))||(( !( !(((int)now.done[3])))&& !(((int)now.done[3])))||(( !( !(((int)now.done[4])))&& !(((int)now.done[4])))||(( !( !(((int)now.done[5])))&& !(((int)now.done[5])))||(((((( !( !(((int)now.done[8])))&& !(((int)now.done[8])))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))||((((( !( !(((int)now.done[9])))&& !(((int)now.done[9])))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))||(((( !( !(((int)now.done[7])))&& !(((int)now.done[7])))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))||( !( !(((int)now.done[6])))&& !(((int)now.done[6]))))))))))))))
			continue;
		/* merge: assert(!(((!(!(done[0]))&&!(done[0]))||((!(!(done[1]))&&!(done[1]))||((!(!(done[2]))&&!(done[2]))||((!(!(done[3]))&&!(done[3]))||((!(!(done[4]))&&!(done[4]))||((!(!(done[5]))&&!(done[5]))||((((((!(!(done[8]))&&!(done[8]))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(((((!(!(done[9]))&&!(done[9]))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||((((!(!(done[7]))&&!(done[7]))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(!(!(done[6]))&&!(done[6])))))))))))))(0, 2, 26) */
		reached[4][2] = 1;
		spin_assert( !((( !( !(((int)now.done[0])))&& !(((int)now.done[0])))||(( !( !(((int)now.done[1])))&& !(((int)now.done[1])))||(( !( !(((int)now.done[2])))&& !(((int)now.done[2])))||(( !( !(((int)now.done[3])))&& !(((int)now.done[3])))||(( !( !(((int)now.done[4])))&& !(((int)now.done[4])))||(( !( !(((int)now.done[5])))&& !(((int)now.done[5])))||(((((( !( !(((int)now.done[8])))&& !(((int)now.done[8])))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))||((((( !( !(((int)now.done[9])))&& !(((int)now.done[9])))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))||(((( !( !(((int)now.done[7])))&& !(((int)now.done[7])))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))||( !( !(((int)now.done[6])))&& !(((int)now.done[6]))))))))))))), " !((( !( !(done[0]))&& !(done[0]))||(( !( !(done[1]))&& !(done[1]))||(( !( !(done[2]))&& !(done[2]))||(( !( !(done[3]))&& !(done[3]))||(( !( !(done[4]))&& !(done[4]))||(( !( !(done[5]))&& !(done[5]))||(((((( !( !(done[8]))&& !(done[8]))&&( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9])))))))))&&( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9]))))))))))&&( !( !(done[1]))||( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9])))))))))))&&( !( !(done[0]))||( !( !(done[1]))||( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9]))))))))))))||((((( !( !(done[9]))&& !(done[9]))&&( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9]))))))))))&&( !( !(done[1]))||( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9])))))))))))&&( !( !(done[0]))||( !( !(done[1]))||( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9]))))))))))))||(((( !( !(done[7]))&& !(done[7]))&&( !( !(done[1]))||( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9])))))))))))&&( !( !(done[0]))||( !( !(done[1]))||( !( !(done[2]))||( !( !(done[3]))||( !( !(done[4]))||( !( !(done[5]))||( !( !(done[6]))||( !( !(done[7]))||( !( !(done[8]))|| !( !(done[9]))))))))))))||( !( !(done[6]))&& !(done[6]))))))))))))", II, tt, t);
		/* merge: .(goto)(0, 27, 26) */
		reached[4][27] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 6: // STATE 4 - _spin_nvr.tmp:79 - [((((((((!(!(done[9]))&&(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))&&(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported4 = 0;
			if (verbose && !reported4)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported4 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported4 = 0;
			if (verbose && !reported4)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported4 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][4] = 1;
		if (!(((((((( !( !(((int)now.done[9])))&&( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))&&( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))&&( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 7: // STATE 6 - _spin_nvr.tmp:80 - [((((((((!(!(done[8]))&&(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))&&(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported6 = 0;
			if (verbose && !reported6)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported6 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported6 = 0;
			if (verbose && !reported6)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported6 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][6] = 1;
		if (!(((((((( !( !(((int)now.done[8])))&&( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))&&( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))&&( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 8: // STATE 8 - _spin_nvr.tmp:81 - [(((((((!(!(done[7]))&&(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported8 = 0;
			if (verbose && !reported8)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported8 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported8 = 0;
			if (verbose && !reported8)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported8 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][8] = 1;
		if (!((((((( !( !(((int)now.done[7])))&&( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))&&( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 9: // STATE 10 - _spin_nvr.tmp:82 - [((((((!(!(done[6]))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][10] = 1;
		if (!(((((( !( !(((int)now.done[6])))&&( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 10: // STATE 12 - _spin_nvr.tmp:83 - [(((((!(!(done[5]))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported12 = 0;
			if (verbose && !reported12)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported12 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported12 = 0;
			if (verbose && !reported12)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported12 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][12] = 1;
		if (!((((( !( !(((int)now.done[5])))&&( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 11: // STATE 14 - _spin_nvr.tmp:84 - [((((!(!(done[4]))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported14 = 0;
			if (verbose && !reported14)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported14 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported14 = 0;
			if (verbose && !reported14)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported14 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][14] = 1;
		if (!(((( !( !(((int)now.done[4])))&&( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 12: // STATE 16 - _spin_nvr.tmp:85 - [(((!(!(done[3]))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported16 = 0;
			if (verbose && !reported16)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported16 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported16 = 0;
			if (verbose && !reported16)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported16 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][16] = 1;
		if (!((( !( !(((int)now.done[3])))&&( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9]))))))))))))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 13: // STATE 18 - _spin_nvr.tmp:86 - [((!(!(done[2]))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported18 = 0;
			if (verbose && !reported18)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported18 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported18 = 0;
			if (verbose && !reported18)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported18 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][18] = 1;
		if (!(( !( !(((int)now.done[2])))&&( !( !(((int)now.done[0])))||( !( !(((int)now.done[1])))||( !( !(((int)now.done[2])))||( !( !(((int)now.done[3])))||( !( !(((int)now.done[4])))||( !( !(((int)now.done[5])))||( !( !(((int)now.done[6])))||( !( !(((int)now.done[7])))||( !( !(((int)now.done[8])))|| !( !(((int)now.done[9])))))))))))))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 14: // STATE 20 - _spin_nvr.tmp:87 - [(!(!(done[1])))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported20 = 0;
			if (verbose && !reported20)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported20 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported20 = 0;
			if (verbose && !reported20)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported20 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][20] = 1;
		if (!( !( !(((int)now.done[1])))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 15: // STATE 22 - _spin_nvr.tmp:88 - [(!(!(done[0])))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported22 = 0;
			if (verbose && !reported22)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported22 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported22 = 0;
			if (verbose && !reported22)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported22 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][22] = 1;
		if (!( !( !(((int)now.done[0])))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 16: // STATE 29 - _spin_nvr.tmp:93 - [(!(done[9]))] (34:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported29 = 0;
			if (verbose && !reported29)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported29 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported29 = 0;
			if (verbose && !reported29)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported29 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][29] = 1;
		if (!( !(((int)now.done[9]))))
			continue;
		/* merge: assert(!(!(done[9])))(0, 30, 34) */
		reached[4][30] = 1;
		spin_assert( !( !(((int)now.done[9]))), " !( !(done[9]))", II, tt, t);
		/* merge: .(goto)(0, 35, 34) */
		reached[4][35] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 17: // STATE 37 - _spin_nvr.tmp:98 - [(!(done[8]))] (42:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported37 = 0;
			if (verbose && !reported37)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported37 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported37 = 0;
			if (verbose && !reported37)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported37 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][37] = 1;
		if (!( !(((int)now.done[8]))))
			continue;
		/* merge: assert(!(!(done[8])))(0, 38, 42) */
		reached[4][38] = 1;
		spin_assert( !( !(((int)now.done[8]))), " !( !(done[8]))", II, tt, t);
		/* merge: .(goto)(0, 43, 42) */
		reached[4][43] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 18: // STATE 45 - _spin_nvr.tmp:103 - [(!(done[7]))] (50:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported45 = 0;
			if (verbose && !reported45)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported45 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported45 = 0;
			if (verbose && !reported45)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported45 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][45] = 1;
		if (!( !(((int)now.done[7]))))
			continue;
		/* merge: assert(!(!(done[7])))(0, 46, 50) */
		reached[4][46] = 1;
		spin_assert( !( !(((int)now.done[7]))), " !( !(done[7]))", II, tt, t);
		/* merge: .(goto)(0, 51, 50) */
		reached[4][51] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 19: // STATE 53 - _spin_nvr.tmp:108 - [(!(done[6]))] (58:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported53 = 0;
			if (verbose && !reported53)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported53 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported53 = 0;
			if (verbose && !reported53)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported53 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][53] = 1;
		if (!( !(((int)now.done[6]))))
			continue;
		/* merge: assert(!(!(done[6])))(0, 54, 58) */
		reached[4][54] = 1;
		spin_assert( !( !(((int)now.done[6]))), " !( !(done[6]))", II, tt, t);
		/* merge: .(goto)(0, 59, 58) */
		reached[4][59] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 20: // STATE 61 - _spin_nvr.tmp:113 - [(!(done[5]))] (66:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported61 = 0;
			if (verbose && !reported61)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported61 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported61 = 0;
			if (verbose && !reported61)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported61 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][61] = 1;
		if (!( !(((int)now.done[5]))))
			continue;
		/* merge: assert(!(!(done[5])))(0, 62, 66) */
		reached[4][62] = 1;
		spin_assert( !( !(((int)now.done[5]))), " !( !(done[5]))", II, tt, t);
		/* merge: .(goto)(0, 67, 66) */
		reached[4][67] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 21: // STATE 69 - _spin_nvr.tmp:118 - [(!(done[4]))] (74:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported69 = 0;
			if (verbose && !reported69)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported69 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported69 = 0;
			if (verbose && !reported69)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported69 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][69] = 1;
		if (!( !(((int)now.done[4]))))
			continue;
		/* merge: assert(!(!(done[4])))(0, 70, 74) */
		reached[4][70] = 1;
		spin_assert( !( !(((int)now.done[4]))), " !( !(done[4]))", II, tt, t);
		/* merge: .(goto)(0, 75, 74) */
		reached[4][75] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 22: // STATE 77 - _spin_nvr.tmp:123 - [(!(done[3]))] (82:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported77 = 0;
			if (verbose && !reported77)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported77 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported77 = 0;
			if (verbose && !reported77)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported77 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][77] = 1;
		if (!( !(((int)now.done[3]))))
			continue;
		/* merge: assert(!(!(done[3])))(0, 78, 82) */
		reached[4][78] = 1;
		spin_assert( !( !(((int)now.done[3]))), " !( !(done[3]))", II, tt, t);
		/* merge: .(goto)(0, 83, 82) */
		reached[4][83] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 23: // STATE 85 - _spin_nvr.tmp:128 - [(!(done[2]))] (90:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported85 = 0;
			if (verbose && !reported85)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported85 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported85 = 0;
			if (verbose && !reported85)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported85 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][85] = 1;
		if (!( !(((int)now.done[2]))))
			continue;
		/* merge: assert(!(!(done[2])))(0, 86, 90) */
		reached[4][86] = 1;
		spin_assert( !( !(((int)now.done[2]))), " !( !(done[2]))", II, tt, t);
		/* merge: .(goto)(0, 91, 90) */
		reached[4][91] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 24: // STATE 93 - _spin_nvr.tmp:133 - [(!(done[1]))] (98:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported93 = 0;
			if (verbose && !reported93)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported93 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported93 = 0;
			if (verbose && !reported93)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported93 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][93] = 1;
		if (!( !(((int)now.done[1]))))
			continue;
		/* merge: assert(!(!(done[1])))(0, 94, 98) */
		reached[4][94] = 1;
		spin_assert( !( !(((int)now.done[1]))), " !( !(done[1]))", II, tt, t);
		/* merge: .(goto)(0, 99, 98) */
		reached[4][99] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 25: // STATE 101 - _spin_nvr.tmp:138 - [(!(done[0]))] (106:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported101 = 0;
			if (verbose && !reported101)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported101 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported101 = 0;
			if (verbose && !reported101)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported101 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][101] = 1;
		if (!( !(((int)now.done[0]))))
			continue;
		/* merge: assert(!(!(done[0])))(0, 102, 106) */
		reached[4][102] = 1;
		spin_assert( !( !(((int)now.done[0]))), " !( !(done[0]))", II, tt, t);
		/* merge: .(goto)(0, 107, 106) */
		reached[4][107] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 26: // STATE 110 - _spin_nvr.tmp:143 - [-end-] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported110 = 0;
			if (verbose && !reported110)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported110 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported110 = 0;
			if (verbose && !reported110)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported110 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][110] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* CLAIM p2 */
	case 27: // STATE 1 - _spin_nvr.tmp:69 - [(!((!((((((((((done[0]&&done[1])&&done[2])&&done[3])&&done[4])&&done[5])&&done[6])&&done[7])&&done[8])&&done[9]))||done[0])))] (6:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[3][1] = 1;
		if (!( !(( !((((((((((((int)now.done[0])&&((int)now.done[1]))&&((int)now.done[2]))&&((int)now.done[3]))&&((int)now.done[4]))&&((int)now.done[5]))&&((int)now.done[6]))&&((int)now.done[7]))&&((int)now.done[8]))&&((int)now.done[9])))||((int)now.done[0])))))
			continue;
		/* merge: assert(!(!((!((((((((((done[0]&&done[1])&&done[2])&&done[3])&&done[4])&&done[5])&&done[6])&&done[7])&&done[8])&&done[9]))||done[0]))))(0, 2, 6) */
		reached[3][2] = 1;
		spin_assert( !( !(( !((((((((((((int)now.done[0])&&((int)now.done[1]))&&((int)now.done[2]))&&((int)now.done[3]))&&((int)now.done[4]))&&((int)now.done[5]))&&((int)now.done[6]))&&((int)now.done[7]))&&((int)now.done[8]))&&((int)now.done[9])))||((int)now.done[0])))), " !( !(( !((((((((((done[0]&&done[1])&&done[2])&&done[3])&&done[4])&&done[5])&&done[6])&&done[7])&&done[8])&&done[9]))||done[0])))", II, tt, t);
		/* merge: .(goto)(0, 7, 6) */
		reached[3][7] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 28: // STATE 10 - _spin_nvr.tmp:74 - [-end-] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[3][10] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* CLAIM p1 */
	case 29: // STATE 1 - _spin_nvr.tmp:4 - [(!(done[9]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][1] = 1;
		if (!( !(((int)now.done[9]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 30: // STATE 3 - _spin_nvr.tmp:5 - [(!(done[8]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported3 = 0;
			if (verbose && !reported3)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported3 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported3 = 0;
			if (verbose && !reported3)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported3 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][3] = 1;
		if (!( !(((int)now.done[8]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 31: // STATE 5 - _spin_nvr.tmp:6 - [(!(done[7]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported5 = 0;
			if (verbose && !reported5)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported5 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported5 = 0;
			if (verbose && !reported5)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported5 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][5] = 1;
		if (!( !(((int)now.done[7]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 32: // STATE 7 - _spin_nvr.tmp:7 - [(!(done[6]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported7 = 0;
			if (verbose && !reported7)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported7 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported7 = 0;
			if (verbose && !reported7)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported7 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][7] = 1;
		if (!( !(((int)now.done[6]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 33: // STATE 9 - _spin_nvr.tmp:8 - [(!(done[5]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported9 = 0;
			if (verbose && !reported9)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported9 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported9 = 0;
			if (verbose && !reported9)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported9 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][9] = 1;
		if (!( !(((int)now.done[5]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 34: // STATE 11 - _spin_nvr.tmp:9 - [(!(done[4]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported11 = 0;
			if (verbose && !reported11)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported11 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported11 = 0;
			if (verbose && !reported11)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported11 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][11] = 1;
		if (!( !(((int)now.done[4]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 35: // STATE 13 - _spin_nvr.tmp:10 - [(!(done[3]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported13 = 0;
			if (verbose && !reported13)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported13 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported13 = 0;
			if (verbose && !reported13)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported13 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][13] = 1;
		if (!( !(((int)now.done[3]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 36: // STATE 15 - _spin_nvr.tmp:11 - [(!(done[2]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported15 = 0;
			if (verbose && !reported15)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported15 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported15 = 0;
			if (verbose && !reported15)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported15 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][15] = 1;
		if (!( !(((int)now.done[2]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 37: // STATE 17 - _spin_nvr.tmp:12 - [(!(done[1]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported17 = 0;
			if (verbose && !reported17)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported17 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported17 = 0;
			if (verbose && !reported17)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported17 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][17] = 1;
		if (!( !(((int)now.done[1]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 38: // STATE 19 - _spin_nvr.tmp:13 - [(!(done[0]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported19 = 0;
			if (verbose && !reported19)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported19 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported19 = 0;
			if (verbose && !reported19)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported19 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][19] = 1;
		if (!( !(((int)now.done[0]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 39: // STATE 24 - _spin_nvr.tmp:18 - [(!(done[9]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported24 = 0;
			if (verbose && !reported24)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported24 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported24 = 0;
			if (verbose && !reported24)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported24 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][24] = 1;
		if (!( !(((int)now.done[9]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 40: // STATE 29 - _spin_nvr.tmp:23 - [(!(done[8]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported29 = 0;
			if (verbose && !reported29)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported29 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported29 = 0;
			if (verbose && !reported29)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported29 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][29] = 1;
		if (!( !(((int)now.done[8]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 41: // STATE 34 - _spin_nvr.tmp:28 - [(!(done[7]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported34 = 0;
			if (verbose && !reported34)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported34 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported34 = 0;
			if (verbose && !reported34)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported34 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][34] = 1;
		if (!( !(((int)now.done[7]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 42: // STATE 39 - _spin_nvr.tmp:33 - [(!(done[6]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported39 = 0;
			if (verbose && !reported39)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported39 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported39 = 0;
			if (verbose && !reported39)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported39 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][39] = 1;
		if (!( !(((int)now.done[6]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 43: // STATE 44 - _spin_nvr.tmp:38 - [(!(done[5]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported44 = 0;
			if (verbose && !reported44)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported44 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported44 = 0;
			if (verbose && !reported44)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported44 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][44] = 1;
		if (!( !(((int)now.done[5]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 44: // STATE 49 - _spin_nvr.tmp:43 - [(!(done[4]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported49 = 0;
			if (verbose && !reported49)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported49 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported49 = 0;
			if (verbose && !reported49)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported49 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][49] = 1;
		if (!( !(((int)now.done[4]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 45: // STATE 54 - _spin_nvr.tmp:48 - [(!(done[3]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported54 = 0;
			if (verbose && !reported54)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported54 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported54 = 0;
			if (verbose && !reported54)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported54 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][54] = 1;
		if (!( !(((int)now.done[3]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 46: // STATE 59 - _spin_nvr.tmp:53 - [(!(done[2]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported59 = 0;
			if (verbose && !reported59)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported59 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported59 = 0;
			if (verbose && !reported59)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported59 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][59] = 1;
		if (!( !(((int)now.done[2]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 47: // STATE 64 - _spin_nvr.tmp:58 - [(!(done[1]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported64 = 0;
			if (verbose && !reported64)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported64 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported64 = 0;
			if (verbose && !reported64)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported64 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][64] = 1;
		if (!( !(((int)now.done[1]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 48: // STATE 69 - _spin_nvr.tmp:63 - [(!(done[0]))] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported69 = 0;
			if (verbose && !reported69)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported69 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported69 = 0;
			if (verbose && !reported69)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported69 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][69] = 1;
		if (!( !(((int)now.done[0]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 49: // STATE 74 - _spin_nvr.tmp:65 - [-end-] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported74 = 0;
			if (verbose && !reported74)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported74 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported74 = 0;
			if (verbose && !reported74)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported74 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][74] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC :init: */
	case 50: // STATE 1 - model.pml:76 - [i = 0] (0:0:1 - 1)
		IfNotBlocked
		reached[1][1] = 1;
		(trpt+1)->bup.oval = ((P1 *)_this)->_2_1_i;
		((P1 *)_this)->_2_1_i = 0;
#ifdef VAR_RANGES
		logval(":init::i", ((P1 *)_this)->_2_1_i);
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 51: // STATE 2 - model.pml:77 - [((i<10))] (0:0:0 - 1)
		IfNotBlocked
		reached[1][2] = 1;
		if (!((((P1 *)_this)->_2_1_i<10)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 52: // STATE 3 - model.pml:77 - [(run task_runner(i))] (0:0:0 - 1)
		IfNotBlocked
		reached[1][3] = 1;
		if (!(addproc(II, 1, 0, ((P1 *)_this)->_2_1_i)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 53: // STATE 4 - model.pml:77 - [i = (i+1)] (0:0:1 - 1)
		IfNotBlocked
		reached[1][4] = 1;
		(trpt+1)->bup.oval = ((P1 *)_this)->_2_1_i;
		((P1 *)_this)->_2_1_i = (((P1 *)_this)->_2_1_i+1);
#ifdef VAR_RANGES
		logval(":init::i", ((P1 *)_this)->_2_1_i);
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 54: // STATE 11 - model.pml:81 - [-end-] (0:0:0 - 1)
		IfNotBlocked
		reached[1][11] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC task_runner */
	case 55: // STATE 1 - model.pml:38 - [(((done[id]==0)&&(id==next_task)))] (0:0:0 - 1)
		IfNotBlocked
		reached[0][1] = 1;
		if (!(((((int)now.done[ Index(((P0 *)_this)->id, 10) ])==0)&&(((P0 *)_this)->id==now.next_task))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 56: // STATE 2 - model.pml:39 - [done[id] = 1] (0:0:1 - 1)
		IfNotBlocked
		reached[0][2] = 1;
		(trpt+1)->bup.oval = ((int)now.done[ Index(((P0 *)_this)->id, 10) ]);
		now.done[ Index(((P0 *)_this)->id, 10) ] = 1;
#ifdef VAR_RANGES
		logval("done[task_runner:id]", ((int)now.done[ Index(((P0 *)_this)->id, 10) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 57: // STATE 3 - model.pml:42 - [pending_tasks = 0] (0:15:2 - 1)
		IfNotBlocked
		reached[0][3] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((int)((P0 *)_this)->pending_tasks);
		((P0 *)_this)->pending_tasks = 0;
#ifdef VAR_RANGES
		logval("task_runner:pending_tasks", ((int)((P0 *)_this)->pending_tasks));
#endif
		;
		/* merge: k = 0(15, 4, 15) */
		reached[0][4] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P0 *)_this)->k);
		((P0 *)_this)->k = 0;
#ifdef VAR_RANGES
		logval("task_runner:k", ((int)((P0 *)_this)->k));
#endif
		;
		/* merge: .(goto)(0, 16, 15) */
		reached[0][16] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 58: // STATE 5 - model.pml:46 - [((k<10))] (0:0:0 - 1)
		IfNotBlocked
		reached[0][5] = 1;
		if (!((((int)((P0 *)_this)->k)<10)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 59: // STATE 6 - model.pml:48 - [((done[k]==0))] (0:0:1 - 1)
		IfNotBlocked
		reached[0][6] = 1;
		if (!((((int)now.done[ Index(((int)((P0 *)_this)->k), 10) ])==0)))
			continue;
		if (TstOnly) return 1; /* TT */
		/* dead 1: k */  (trpt+1)->bup.oval = ((P0 *)_this)->k;
#ifdef HAS_CODE
		if (!readtrail)
#endif
			((P0 *)_this)->k = 0;
		_m = 3; goto P999; /* 0 */
	case 60: // STATE 7 - model.pml:49 - [pending_tasks = 1] (0:0:1 - 1)
		IfNotBlocked
		reached[0][7] = 1;
		(trpt+1)->bup.oval = ((int)((P0 *)_this)->pending_tasks);
		((P0 *)_this)->pending_tasks = 1;
#ifdef VAR_RANGES
		logval("task_runner:pending_tasks", ((int)((P0 *)_this)->pending_tasks));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 61: // STATE 10 - model.pml:51 - [k = (k+1)] (0:0:1 - 1)
		IfNotBlocked
		reached[0][10] = 1;
		(trpt+1)->bup.oval = ((int)((P0 *)_this)->k);
		((P0 *)_this)->k = (((int)((P0 *)_this)->k)+1);
#ifdef VAR_RANGES
		logval("task_runner:k", ((int)((P0 *)_this)->k));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 62: // STATE 18 - model.pml:57 - [(!(pending_tasks))] (0:0:1 - 1)
		IfNotBlocked
		reached[0][18] = 1;
		if (!( !(((int)((P0 *)_this)->pending_tasks))))
			continue;
		if (TstOnly) return 1; /* TT */
		/* dead 1: pending_tasks */  (trpt+1)->bup.oval = ((P0 *)_this)->pending_tasks;
#ifdef HAS_CODE
		if (!readtrail)
#endif
			((P0 *)_this)->pending_tasks = 0;
		_m = 3; goto P999; /* 0 */
	case 63: // STATE 21 - model.pml:60 - [next = ((id+1)%10)] (0:0:1 - 1)
		IfNotBlocked
		reached[0][21] = 1;
		(trpt+1)->bup.oval = ((int)((P0 *)_this)->next);
		((P0 *)_this)->next = ((((P0 *)_this)->id+1)%10);
#ifdef VAR_RANGES
		logval("task_runner:next", ((int)((P0 *)_this)->next));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 64: // STATE 22 - model.pml:62 - [((done[next]==0))] (0:0:0 - 1)
		IfNotBlocked
		reached[0][22] = 1;
		if (!((((int)now.done[ Index(((int)((P0 *)_this)->next), 10) ])==0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 65: // STATE 23 - model.pml:63 - [next_task = next] (0:0:1 - 1)
		IfNotBlocked
		reached[0][23] = 1;
		(trpt+1)->bup.oval = now.next_task;
		now.next_task = ((int)((P0 *)_this)->next);
#ifdef VAR_RANGES
		logval("next_task", now.next_task);
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 66: // STATE 26 - model.pml:65 - [next = ((next+1)%10)] (0:0:1 - 1)
		IfNotBlocked
		reached[0][26] = 1;
		(trpt+1)->bup.oval = ((int)((P0 *)_this)->next);
		((P0 *)_this)->next = ((((int)((P0 *)_this)->next)+1)%10);
#ifdef VAR_RANGES
		logval("task_runner:next", ((int)((P0 *)_this)->next));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 67: // STATE 35 - model.pml:69 - [-end-] (0:0:0 - 3)
		IfNotBlocked
		reached[0][35] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */
	case  _T5:	/* np_ */
		if (!((!(trpt->o_pm&4) && !(trpt->tau&128))))
			continue;
		/* else fall through */
	case  _T2:	/* true */
		_m = 3; goto P999;
#undef rand
	}

