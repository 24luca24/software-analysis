#ifdef PEG
struct T_SRC {
	char *fl; int ln;
} T_SRC[NTRANS];

void
tr_2_src(int m, char *file, int ln)
{	T_SRC[m].fl = file;
	T_SRC[m].ln = ln;
}

void
putpeg(int n, int m)
{	printf("%5d	trans %4d ", m, n);
	printf("%s:%d\n",
		T_SRC[n].fl, T_SRC[n].ln);
}
#endif

void
settable(void)
{	Trans *T;
	Trans *settr(int, int, int, int, int, char *, int, int, int);

	trans = (Trans ***) emalloc(7*sizeof(Trans **));

	/* proctype 5: p4 */

	trans[5] = (Trans **) emalloc(11*sizeof(Trans *));

	trans[5][7]	= settr(246,0,6,1,0,".(goto)", 0, 2, 0);
	T = trans[5][6] = settr(245,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(245,0,3,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(245,0,4,0,0,"DO", 0, 2, 0);
	T = trans[ 5][3] = settr(242,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(242,2,1,0,0,"ATOMIC", 1, 2, 0);
	trans[5][1]	= settr(240,0,6,3,3,"(!(!((done[0]&&done[1]))))", 1, 2, 0); /* m: 2 -> 6,0 */
	reached5[2] = 1;
	trans[5][2]	= settr(0,0,0,0,0,"assert(!(!(!((done[0]&&done[1])))))",0,0,0);
	trans[5][4]	= settr(243,0,6,1,0,"(1)", 0, 2, 0);
	trans[5][5]	= settr(244,0,6,1,0,"goto T0_init", 0, 2, 0);
	trans[5][8]	= settr(247,0,9,1,0,"break", 0, 2, 0);
	trans[5][9]	= settr(248,0,10,1,0,"(1)", 0, 2, 0);
	trans[5][10]	= settr(249,0,0,4,4,"-end-", 0, 3500, 0);

	/* proctype 4: p3 */

	trans[4] = (Trans **) emalloc(111*sizeof(Trans *));

	trans[4][27]	= settr(156,0,26,1,0,".(goto)", 0, 2, 0);
	T = trans[4][26] = settr(155,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,3,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,4,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,6,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,8,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,10,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,12,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,14,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,16,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,18,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,20,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(155,0,22,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(155,0,24,0,0,"DO", 0, 2, 0);
	T = trans[ 4][3] = settr(132,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(132,2,1,0,0,"ATOMIC", 1, 2, 0);
	trans[4][1]	= settr(130,0,26,5,5,"(((!(!(done[0]))&&!(done[0]))||((!(!(done[1]))&&!(done[1]))||((!(!(done[2]))&&!(done[2]))||((!(!(done[3]))&&!(done[3]))||((!(!(done[4]))&&!(done[4]))||((!(!(done[5]))&&!(done[5]))||((((((!(!(done[8]))&&!(done[8]))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(((((!(!(done[9]))&&!(done[9]))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||((((!(!(done[7]))&&!(done[7]))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(!(!(done[6]))&&!(done[6]))))))))))))", 1, 2, 0); /* m: 2 -> 26,0 */
	reached4[2] = 1;
	trans[4][2]	= settr(0,0,0,0,0,"assert(!(((!(!(done[0]))&&!(done[0]))||((!(!(done[1]))&&!(done[1]))||((!(!(done[2]))&&!(done[2]))||((!(!(done[3]))&&!(done[3]))||((!(!(done[4]))&&!(done[4]))||((!(!(done[5]))&&!(done[5]))||((((((!(!(done[8]))&&!(done[8]))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(((((!(!(done[9]))&&!(done[9]))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||((((!(!(done[7]))&&!(done[7]))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))))||(!(!(done[6]))&&!(done[6])))))))))))))",0,0,0);
	trans[4][4]	= settr(133,0,34,6,0,"((((((((!(!(done[9]))&&(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))&&(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][5]	= settr(134,0,34,1,0,"goto T0_S13", 0, 2, 0);
	trans[4][6]	= settr(135,0,42,7,0,"((((((((!(!(done[8]))&&(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))&&(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][7]	= settr(136,0,42,1,0,"goto T0_S18", 0, 2, 0);
	trans[4][8]	= settr(137,0,50,8,0,"(((((((!(!(done[7]))&&(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][9]	= settr(138,0,50,1,0,"goto T0_S23", 0, 2, 0);
	trans[4][10]	= settr(139,0,58,9,0,"((((((!(!(done[6]))&&(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][11]	= settr(140,0,58,1,0,"goto T0_S28", 0, 2, 0);
	trans[4][12]	= settr(141,0,66,10,0,"(((((!(!(done[5]))&&(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][13]	= settr(142,0,66,1,0,"goto T0_S33", 0, 2, 0);
	trans[4][14]	= settr(143,0,74,11,0,"((((!(!(done[4]))&&(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9]))))))))))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][15]	= settr(144,0,74,1,0,"goto T0_S38", 0, 2, 0);
	trans[4][16]	= settr(145,0,82,12,0,"(((!(!(done[3]))&&(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][17]	= settr(146,0,82,1,0,"goto T0_S43", 0, 2, 0);
	trans[4][18]	= settr(147,0,90,13,0,"((!(!(done[2]))&&(!(!(done[0]))||(!(!(done[1]))||(!(!(done[2]))||(!(!(done[3]))||(!(!(done[4]))||(!(!(done[5]))||(!(!(done[6]))||(!(!(done[7]))||(!(!(done[8]))||!(!(done[9])))))))))))))", 1, 2, 0);
	trans[4][19]	= settr(148,0,90,1,0,"goto T0_S48", 0, 2, 0);
	trans[4][20]	= settr(149,0,98,14,0,"(!(!(done[1])))", 1, 2, 0);
	trans[4][21]	= settr(150,0,98,1,0,"goto T0_S53", 0, 2, 0);
	trans[4][22]	= settr(151,0,106,15,0,"(!(!(done[0])))", 1, 2, 0);
	trans[4][23]	= settr(152,0,106,1,0,"goto T0_S58", 0, 2, 0);
	trans[4][24]	= settr(153,0,26,1,0,"(1)", 0, 2, 0);
	trans[4][25]	= settr(154,0,26,1,0,"goto T0_init", 0, 2, 0);
	trans[4][28]	= settr(157,0,34,1,0,"break", 0, 2, 0);
	trans[4][35]	= settr(164,0,34,1,0,".(goto)", 0, 2, 0);
	T = trans[4][34] = settr(163,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(163,0,31,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(163,0,32,0,0,"DO", 0, 2, 0);
	T = trans[ 4][31] = settr(160,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(160,2,29,0,0,"ATOMIC", 1, 2, 0);
	trans[4][29]	= settr(158,0,34,16,16,"(!(done[9]))", 1, 2, 0); /* m: 30 -> 34,0 */
	reached4[30] = 1;
	trans[4][30]	= settr(0,0,0,0,0,"assert(!(!(done[9])))",0,0,0);
	trans[4][32]	= settr(161,0,34,1,0,"(1)", 0, 2, 0);
	trans[4][33]	= settr(162,0,34,1,0,"goto T0_S13", 0, 2, 0);
	trans[4][36]	= settr(165,0,42,1,0,"break", 0, 2, 0);
	trans[4][43]	= settr(172,0,42,1,0,".(goto)", 0, 2, 0);
	T = trans[4][42] = settr(171,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(171,0,39,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(171,0,40,0,0,"DO", 0, 2, 0);
	T = trans[ 4][39] = settr(168,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(168,2,37,0,0,"ATOMIC", 1, 2, 0);
	trans[4][37]	= settr(166,0,42,17,17,"(!(done[8]))", 1, 2, 0); /* m: 38 -> 42,0 */
	reached4[38] = 1;
	trans[4][38]	= settr(0,0,0,0,0,"assert(!(!(done[8])))",0,0,0);
	trans[4][40]	= settr(169,0,42,1,0,"(1)", 0, 2, 0);
	trans[4][41]	= settr(170,0,42,1,0,"goto T0_S18", 0, 2, 0);
	trans[4][44]	= settr(173,0,50,1,0,"break", 0, 2, 0);
	trans[4][51]	= settr(180,0,50,1,0,".(goto)", 0, 2, 0);
	T = trans[4][50] = settr(179,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(179,0,47,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(179,0,48,0,0,"DO", 0, 2, 0);
	T = trans[ 4][47] = settr(176,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(176,2,45,0,0,"ATOMIC", 1, 2, 0);
	trans[4][45]	= settr(174,0,50,18,18,"(!(done[7]))", 1, 2, 0); /* m: 46 -> 50,0 */
	reached4[46] = 1;
	trans[4][46]	= settr(0,0,0,0,0,"assert(!(!(done[7])))",0,0,0);
	trans[4][48]	= settr(177,0,50,1,0,"(1)", 0, 2, 0);
	trans[4][49]	= settr(178,0,50,1,0,"goto T0_S23", 0, 2, 0);
	trans[4][52]	= settr(181,0,58,1,0,"break", 0, 2, 0);
	trans[4][59]	= settr(188,0,58,1,0,".(goto)", 0, 2, 0);
	T = trans[4][58] = settr(187,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(187,0,55,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(187,0,56,0,0,"DO", 0, 2, 0);
	T = trans[ 4][55] = settr(184,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(184,2,53,0,0,"ATOMIC", 1, 2, 0);
	trans[4][53]	= settr(182,0,58,19,19,"(!(done[6]))", 1, 2, 0); /* m: 54 -> 58,0 */
	reached4[54] = 1;
	trans[4][54]	= settr(0,0,0,0,0,"assert(!(!(done[6])))",0,0,0);
	trans[4][56]	= settr(185,0,58,1,0,"(1)", 0, 2, 0);
	trans[4][57]	= settr(186,0,58,1,0,"goto T0_S28", 0, 2, 0);
	trans[4][60]	= settr(189,0,66,1,0,"break", 0, 2, 0);
	trans[4][67]	= settr(196,0,66,1,0,".(goto)", 0, 2, 0);
	T = trans[4][66] = settr(195,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(195,0,63,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(195,0,64,0,0,"DO", 0, 2, 0);
	T = trans[ 4][63] = settr(192,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(192,2,61,0,0,"ATOMIC", 1, 2, 0);
	trans[4][61]	= settr(190,0,66,20,20,"(!(done[5]))", 1, 2, 0); /* m: 62 -> 66,0 */
	reached4[62] = 1;
	trans[4][62]	= settr(0,0,0,0,0,"assert(!(!(done[5])))",0,0,0);
	trans[4][64]	= settr(193,0,66,1,0,"(1)", 0, 2, 0);
	trans[4][65]	= settr(194,0,66,1,0,"goto T0_S33", 0, 2, 0);
	trans[4][68]	= settr(197,0,74,1,0,"break", 0, 2, 0);
	trans[4][75]	= settr(204,0,74,1,0,".(goto)", 0, 2, 0);
	T = trans[4][74] = settr(203,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(203,0,71,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(203,0,72,0,0,"DO", 0, 2, 0);
	T = trans[ 4][71] = settr(200,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(200,2,69,0,0,"ATOMIC", 1, 2, 0);
	trans[4][69]	= settr(198,0,74,21,21,"(!(done[4]))", 1, 2, 0); /* m: 70 -> 74,0 */
	reached4[70] = 1;
	trans[4][70]	= settr(0,0,0,0,0,"assert(!(!(done[4])))",0,0,0);
	trans[4][72]	= settr(201,0,74,1,0,"(1)", 0, 2, 0);
	trans[4][73]	= settr(202,0,74,1,0,"goto T0_S38", 0, 2, 0);
	trans[4][76]	= settr(205,0,82,1,0,"break", 0, 2, 0);
	trans[4][83]	= settr(212,0,82,1,0,".(goto)", 0, 2, 0);
	T = trans[4][82] = settr(211,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(211,0,79,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(211,0,80,0,0,"DO", 0, 2, 0);
	T = trans[ 4][79] = settr(208,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(208,2,77,0,0,"ATOMIC", 1, 2, 0);
	trans[4][77]	= settr(206,0,82,22,22,"(!(done[3]))", 1, 2, 0); /* m: 78 -> 82,0 */
	reached4[78] = 1;
	trans[4][78]	= settr(0,0,0,0,0,"assert(!(!(done[3])))",0,0,0);
	trans[4][80]	= settr(209,0,82,1,0,"(1)", 0, 2, 0);
	trans[4][81]	= settr(210,0,82,1,0,"goto T0_S43", 0, 2, 0);
	trans[4][84]	= settr(213,0,90,1,0,"break", 0, 2, 0);
	trans[4][91]	= settr(220,0,90,1,0,".(goto)", 0, 2, 0);
	T = trans[4][90] = settr(219,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(219,0,87,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(219,0,88,0,0,"DO", 0, 2, 0);
	T = trans[ 4][87] = settr(216,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(216,2,85,0,0,"ATOMIC", 1, 2, 0);
	trans[4][85]	= settr(214,0,90,23,23,"(!(done[2]))", 1, 2, 0); /* m: 86 -> 90,0 */
	reached4[86] = 1;
	trans[4][86]	= settr(0,0,0,0,0,"assert(!(!(done[2])))",0,0,0);
	trans[4][88]	= settr(217,0,90,1,0,"(1)", 0, 2, 0);
	trans[4][89]	= settr(218,0,90,1,0,"goto T0_S48", 0, 2, 0);
	trans[4][92]	= settr(221,0,98,1,0,"break", 0, 2, 0);
	trans[4][99]	= settr(228,0,98,1,0,".(goto)", 0, 2, 0);
	T = trans[4][98] = settr(227,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(227,0,95,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(227,0,96,0,0,"DO", 0, 2, 0);
	T = trans[ 4][95] = settr(224,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(224,2,93,0,0,"ATOMIC", 1, 2, 0);
	trans[4][93]	= settr(222,0,98,24,24,"(!(done[1]))", 1, 2, 0); /* m: 94 -> 98,0 */
	reached4[94] = 1;
	trans[4][94]	= settr(0,0,0,0,0,"assert(!(!(done[1])))",0,0,0);
	trans[4][96]	= settr(225,0,98,1,0,"(1)", 0, 2, 0);
	trans[4][97]	= settr(226,0,98,1,0,"goto T0_S53", 0, 2, 0);
	trans[4][100]	= settr(229,0,106,1,0,"break", 0, 2, 0);
	trans[4][107]	= settr(236,0,106,1,0,".(goto)", 0, 2, 0);
	T = trans[4][106] = settr(235,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(235,0,103,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(235,0,104,0,0,"DO", 0, 2, 0);
	T = trans[ 4][103] = settr(232,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(232,2,101,0,0,"ATOMIC", 1, 2, 0);
	trans[4][101]	= settr(230,0,106,25,25,"(!(done[0]))", 1, 2, 0); /* m: 102 -> 106,0 */
	reached4[102] = 1;
	trans[4][102]	= settr(0,0,0,0,0,"assert(!(!(done[0])))",0,0,0);
	trans[4][104]	= settr(233,0,106,1,0,"(1)", 0, 2, 0);
	trans[4][105]	= settr(234,0,106,1,0,"goto T0_S58", 0, 2, 0);
	trans[4][108]	= settr(237,0,109,1,0,"break", 0, 2, 0);
	trans[4][109]	= settr(238,0,110,1,0,"(1)", 0, 2, 0);
	trans[4][110]	= settr(239,0,0,26,26,"-end-", 0, 3500, 0);

	/* proctype 3: p2 */

	trans[3] = (Trans **) emalloc(11*sizeof(Trans *));

	trans[3][7]	= settr(126,0,6,1,0,".(goto)", 0, 2, 0);
	T = trans[3][6] = settr(125,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(125,0,3,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(125,0,4,0,0,"DO", 0, 2, 0);
	T = trans[ 3][3] = settr(122,2,0,0,0,"ATOMIC", 1, 2, 0);
	T->nxt	= settr(122,2,1,0,0,"ATOMIC", 1, 2, 0);
	trans[3][1]	= settr(120,0,6,27,27,"(!((!((((((((((done[0]&&done[1])&&done[2])&&done[3])&&done[4])&&done[5])&&done[6])&&done[7])&&done[8])&&done[9]))||done[0])))", 1, 2, 0); /* m: 2 -> 6,0 */
	reached3[2] = 1;
	trans[3][2]	= settr(0,0,0,0,0,"assert(!(!((!((((((((((done[0]&&done[1])&&done[2])&&done[3])&&done[4])&&done[5])&&done[6])&&done[7])&&done[8])&&done[9]))||done[0]))))",0,0,0);
	trans[3][4]	= settr(123,0,6,1,0,"(1)", 0, 2, 0);
	trans[3][5]	= settr(124,0,6,1,0,"goto T0_init", 0, 2, 0);
	trans[3][8]	= settr(127,0,9,1,0,"break", 0, 2, 0);
	trans[3][9]	= settr(128,0,10,1,0,"(1)", 0, 2, 0);
	trans[3][10]	= settr(129,0,0,28,28,"-end-", 0, 3500, 0);

	/* proctype 2: p1 */

	trans[2] = (Trans **) emalloc(75*sizeof(Trans *));

	trans[2][22]	= settr(67,0,21,1,0,".(goto)", 0, 2, 0);
	T = trans[2][21] = settr(66,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,1,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,3,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,5,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,7,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,9,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,11,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,13,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,15,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(66,0,17,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(66,0,19,0,0,"DO", 0, 2, 0);
	trans[2][1]	= settr(46,0,26,29,0,"(!(done[9]))", 1, 2, 0);
	trans[2][2]	= settr(47,0,26,1,0,"goto accept_S12", 0, 2, 0);
	trans[2][3]	= settr(48,0,31,30,0,"(!(done[8]))", 1, 2, 0);
	trans[2][4]	= settr(49,0,31,1,0,"goto accept_S17", 0, 2, 0);
	trans[2][5]	= settr(50,0,36,31,0,"(!(done[7]))", 1, 2, 0);
	trans[2][6]	= settr(51,0,36,1,0,"goto accept_S22", 0, 2, 0);
	trans[2][7]	= settr(52,0,41,32,0,"(!(done[6]))", 1, 2, 0);
	trans[2][8]	= settr(53,0,41,1,0,"goto accept_S27", 0, 2, 0);
	trans[2][9]	= settr(54,0,46,33,0,"(!(done[5]))", 1, 2, 0);
	trans[2][10]	= settr(55,0,46,1,0,"goto accept_S32", 0, 2, 0);
	trans[2][11]	= settr(56,0,51,34,0,"(!(done[4]))", 1, 2, 0);
	trans[2][12]	= settr(57,0,51,1,0,"goto accept_S37", 0, 2, 0);
	trans[2][13]	= settr(58,0,56,35,0,"(!(done[3]))", 1, 2, 0);
	trans[2][14]	= settr(59,0,56,1,0,"goto accept_S42", 0, 2, 0);
	trans[2][15]	= settr(60,0,61,36,0,"(!(done[2]))", 1, 2, 0);
	trans[2][16]	= settr(61,0,61,1,0,"goto accept_S47", 0, 2, 0);
	trans[2][17]	= settr(62,0,66,37,0,"(!(done[1]))", 1, 2, 0);
	trans[2][18]	= settr(63,0,66,1,0,"goto accept_S50", 0, 2, 0);
	trans[2][19]	= settr(64,0,71,38,0,"(!(done[0]))", 1, 2, 0);
	trans[2][20]	= settr(65,0,71,1,0,"goto accept_S53", 0, 2, 0);
	trans[2][23]	= settr(68,0,26,1,0,"break", 0, 2, 0);
	trans[2][27]	= settr(72,0,26,1,0,".(goto)", 0, 2, 0);
	T = trans[2][26] = settr(71,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(71,0,24,0,0,"DO", 0, 2, 0);
	trans[2][24]	= settr(69,0,26,39,0,"(!(done[9]))", 1, 2, 0);
	trans[2][25]	= settr(70,0,26,1,0,"goto accept_S12", 0, 2, 0);
	trans[2][28]	= settr(73,0,31,1,0,"break", 0, 2, 0);
	trans[2][32]	= settr(77,0,31,1,0,".(goto)", 0, 2, 0);
	T = trans[2][31] = settr(76,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(76,0,29,0,0,"DO", 0, 2, 0);
	trans[2][29]	= settr(74,0,31,40,0,"(!(done[8]))", 1, 2, 0);
	trans[2][30]	= settr(75,0,31,1,0,"goto accept_S17", 0, 2, 0);
	trans[2][33]	= settr(78,0,36,1,0,"break", 0, 2, 0);
	trans[2][37]	= settr(82,0,36,1,0,".(goto)", 0, 2, 0);
	T = trans[2][36] = settr(81,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(81,0,34,0,0,"DO", 0, 2, 0);
	trans[2][34]	= settr(79,0,36,41,0,"(!(done[7]))", 1, 2, 0);
	trans[2][35]	= settr(80,0,36,1,0,"goto accept_S22", 0, 2, 0);
	trans[2][38]	= settr(83,0,41,1,0,"break", 0, 2, 0);
	trans[2][42]	= settr(87,0,41,1,0,".(goto)", 0, 2, 0);
	T = trans[2][41] = settr(86,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(86,0,39,0,0,"DO", 0, 2, 0);
	trans[2][39]	= settr(84,0,41,42,0,"(!(done[6]))", 1, 2, 0);
	trans[2][40]	= settr(85,0,41,1,0,"goto accept_S27", 0, 2, 0);
	trans[2][43]	= settr(88,0,46,1,0,"break", 0, 2, 0);
	trans[2][47]	= settr(92,0,46,1,0,".(goto)", 0, 2, 0);
	T = trans[2][46] = settr(91,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(91,0,44,0,0,"DO", 0, 2, 0);
	trans[2][44]	= settr(89,0,46,43,0,"(!(done[5]))", 1, 2, 0);
	trans[2][45]	= settr(90,0,46,1,0,"goto accept_S32", 0, 2, 0);
	trans[2][48]	= settr(93,0,51,1,0,"break", 0, 2, 0);
	trans[2][52]	= settr(97,0,51,1,0,".(goto)", 0, 2, 0);
	T = trans[2][51] = settr(96,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(96,0,49,0,0,"DO", 0, 2, 0);
	trans[2][49]	= settr(94,0,51,44,0,"(!(done[4]))", 1, 2, 0);
	trans[2][50]	= settr(95,0,51,1,0,"goto accept_S37", 0, 2, 0);
	trans[2][53]	= settr(98,0,56,1,0,"break", 0, 2, 0);
	trans[2][57]	= settr(102,0,56,1,0,".(goto)", 0, 2, 0);
	T = trans[2][56] = settr(101,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(101,0,54,0,0,"DO", 0, 2, 0);
	trans[2][54]	= settr(99,0,56,45,0,"(!(done[3]))", 1, 2, 0);
	trans[2][55]	= settr(100,0,56,1,0,"goto accept_S42", 0, 2, 0);
	trans[2][58]	= settr(103,0,61,1,0,"break", 0, 2, 0);
	trans[2][62]	= settr(107,0,61,1,0,".(goto)", 0, 2, 0);
	T = trans[2][61] = settr(106,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(106,0,59,0,0,"DO", 0, 2, 0);
	trans[2][59]	= settr(104,0,61,46,0,"(!(done[2]))", 1, 2, 0);
	trans[2][60]	= settr(105,0,61,1,0,"goto accept_S47", 0, 2, 0);
	trans[2][63]	= settr(108,0,66,1,0,"break", 0, 2, 0);
	trans[2][67]	= settr(112,0,66,1,0,".(goto)", 0, 2, 0);
	T = trans[2][66] = settr(111,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(111,0,64,0,0,"DO", 0, 2, 0);
	trans[2][64]	= settr(109,0,66,47,0,"(!(done[1]))", 1, 2, 0);
	trans[2][65]	= settr(110,0,66,1,0,"goto accept_S50", 0, 2, 0);
	trans[2][68]	= settr(113,0,71,1,0,"break", 0, 2, 0);
	trans[2][72]	= settr(117,0,71,1,0,".(goto)", 0, 2, 0);
	T = trans[2][71] = settr(116,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(116,0,69,0,0,"DO", 0, 2, 0);
	trans[2][69]	= settr(114,0,71,48,0,"(!(done[0]))", 1, 2, 0);
	trans[2][70]	= settr(115,0,71,1,0,"goto accept_S53", 0, 2, 0);
	trans[2][73]	= settr(118,0,74,1,0,"break", 0, 2, 0);
	trans[2][74]	= settr(119,0,0,49,49,"-end-", 0, 3500, 0);

	/* proctype 1: :init: */

	trans[1] = (Trans **) emalloc(12*sizeof(Trans *));

	T = trans[ 1][10] = settr(44,2,0,0,0,"ATOMIC", 0, 2, 0);
	T->nxt	= settr(44,2,1,0,0,"ATOMIC", 0, 2, 0);
	trans[1][1]	= settr(35,2,7,50,50,"i = 0", 0, 2, 0);
	trans[1][8]	= settr(42,2,7,1,0,".(goto)", 0, 2, 0);
	T = trans[1][7] = settr(41,2,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(41,2,2,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(41,2,5,0,0,"DO", 0, 2, 0);
	trans[1][2]	= settr(36,2,3,51,0,"((i<10))", 0, 2, 0);
	trans[1][3]	= settr(37,2,4,52,52,"(run task_runner(i))", 0, 2, 0);
	trans[1][4]	= settr(38,2,7,53,53,"i = (i+1)", 0, 2, 0);
	trans[1][5]	= settr(39,2,6,2,0,"else", 0, 2, 0);
	trans[1][6]	= settr(40,2,9,1,0,"goto :b3", 0, 2, 0);
	trans[1][9]	= settr(43,0,11,1,0,"break", 0, 2, 0);
	trans[1][11]	= settr(45,0,0,54,54,"-end-", 0, 3500, 0);

	/* proctype 0: task_runner */

	trans[0] = (Trans **) emalloc(36*sizeof(Trans *));

	trans[0][33]	= settr(32,0,32,1,0,".(goto)", 0, 2, 0);
	T = trans[0][32] = settr(31,0,0,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(31,0,1,0,0,"DO", 0, 2, 0);
	trans[0][1]	= settr(0,0,2,55,0,"(((done[id]==0)&&(id==next_task)))", 1, 2, 0);
	trans[0][2]	= settr(1,0,3,56,56,"done[id] = 1", 1, 2, 0);
	trans[0][3]	= settr(2,0,15,57,57,"pending_tasks = 0", 0, 2, 0); /* m: 4 -> 0,15 */
	reached0[4] = 1;
	trans[0][4]	= settr(0,0,0,0,0,"k = 0",0,0,0);
	trans[0][16]	= settr(15,0,15,1,0,".(goto)", 0, 2, 0);
	T = trans[0][15] = settr(14,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(14,0,5,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(14,0,13,0,0,"DO", 0, 2, 0);
	trans[0][5]	= settr(4,0,11,58,0,"((k<10))", 0, 2, 0);
	T = trans[0][11] = settr(10,0,0,0,0,"IF", 0, 2, 0);
	T = T->nxt	= settr(10,0,6,0,0,"IF", 0, 2, 0);
	    T->nxt	= settr(10,0,9,0,0,"IF", 0, 2, 0);
	trans[0][6]	= settr(5,0,7,59,59,"((done[k]==0))", 1, 2, 0);
	trans[0][7]	= settr(6,0,30,60,60,"pending_tasks = 1", 0, 2, 0);
	trans[0][8]	= settr(7,0,30,1,0,"goto :b1", 0, 2, 0);
	trans[0][12]	= settr(11,0,15,1,0,".(goto)", 0, 2, 0);
	trans[0][9]	= settr(8,0,10,2,0,"else", 0, 2, 0);
	trans[0][10]	= settr(9,0,15,61,61,"k = (k+1)", 0, 2, 0);
	trans[0][13]	= settr(12,0,30,2,0,"else", 0, 2, 0);
	trans[0][14]	= settr(13,0,30,1,0,"goto :b1", 0, 2, 0);
	trans[0][17]	= settr(16,0,30,1,0,"break", 0, 2, 0);
	T = trans[0][30] = settr(29,0,0,0,0,"IF", 0, 2, 0);
	T = T->nxt	= settr(29,0,18,0,0,"IF", 0, 2, 0);
	    T->nxt	= settr(29,0,20,0,0,"IF", 0, 2, 0);
	trans[0][18]	= settr(17,0,35,62,62,"(!(pending_tasks))", 0, 2, 0);
	trans[0][19]	= settr(18,0,35,1,0,"goto :b0", 0, 2, 0);
	trans[0][31]	= settr(30,0,32,1,0,".(goto)", 0, 2, 0);
	trans[0][20]	= settr(19,0,21,2,0,"else", 0, 2, 0);
	trans[0][21]	= settr(20,0,27,63,63,"next = ((id+1)%10)", 0, 2, 0);
	trans[0][28]	= settr(27,0,27,1,0,".(goto)", 0, 2, 0);
	T = trans[0][27] = settr(26,0,0,0,0,"DO", 0, 2, 0);
	T = T->nxt	= settr(26,0,22,0,0,"DO", 0, 2, 0);
	    T->nxt	= settr(26,0,25,0,0,"DO", 0, 2, 0);
	trans[0][22]	= settr(21,0,23,64,0,"((done[next]==0))", 1, 2, 0);
	trans[0][23]	= settr(22,0,32,65,65,"next_task = next", 1, 2, 0);
	trans[0][24]	= settr(23,0,32,1,0,"goto :b2", 0, 2, 0);
	trans[0][25]	= settr(24,0,26,2,0,"else", 0, 2, 0);
	trans[0][26]	= settr(25,0,27,66,66,"next = ((next+1)%10)", 0, 2, 0);
	trans[0][29]	= settr(28,0,32,1,0,"break", 0, 2, 0);
	trans[0][34]	= settr(33,0,35,1,0,"break", 0, 2, 0);
	trans[0][35]	= settr(34,0,0,67,67,"-end-", 0, 3500, 0);
	/* np_ demon: */
	trans[_NP_] = (Trans **) emalloc(3*sizeof(Trans *));
	T = trans[_NP_][0] = settr(9997,0,1,_T5,0,"(np_)", 1,2,0);
	    T->nxt	  = settr(9998,0,0,_T2,0,"(1)",   0,2,0);
	T = trans[_NP_][1] = settr(9999,0,1,_T5,0,"(np_)", 1,2,0);
}

Trans *
settr(	int t_id, int a, int b, int c, int d,
	char *t, int g, int tpe0, int tpe1)
{	Trans *tmp = (Trans *) emalloc(sizeof(Trans));

	tmp->atom  = a&(6|32);	/* only (2|8|32) have meaning */
	if (!g) tmp->atom |= 8;	/* no global references */
	tmp->st    = b;
	tmp->tpe[0] = tpe0;
	tmp->tpe[1] = tpe1;
	tmp->tp    = t;
	tmp->t_id  = t_id;
	tmp->forw  = c;
	tmp->back  = d;
	return tmp;
}

Trans *
cpytr(Trans *a)
{	Trans *tmp = (Trans *) emalloc(sizeof(Trans));

	int i;
	tmp->atom  = a->atom;
	tmp->st    = a->st;
#ifdef HAS_UNLESS
	tmp->e_trans = a->e_trans;
	for (i = 0; i < HAS_UNLESS; i++)
		tmp->escp[i] = a->escp[i];
#endif
	tmp->tpe[0] = a->tpe[0];
	tmp->tpe[1] = a->tpe[1];
	for (i = 0; i < 6; i++)
	{	tmp->qu[i] = a->qu[i];
		tmp->ty[i] = a->ty[i];
	}
	tmp->tp    = (char *) emalloc(strlen(a->tp)+1);
	strcpy(tmp->tp, a->tp);
	tmp->t_id  = a->t_id;
	tmp->forw  = a->forw;
	tmp->back  = a->back;
	return tmp;
}

#ifndef NOREDUCE
int
srinc_set(int n)
{	if (n <= 2) return LOCAL;
	if (n <= 2+  DELTA) return Q_FULL_F; /* 's' or nfull  */
	if (n <= 2+2*DELTA) return Q_EMPT_F; /* 'r' or nempty */
	if (n <= 2+3*DELTA) return Q_EMPT_T; /* empty */
	if (n <= 2+4*DELTA) return Q_FULL_T; /* full  */
	if (n ==   5*DELTA) return GLOBAL;
	if (n ==   6*DELTA) return TIMEOUT_F;
	if (n ==   7*DELTA) return ALPHA_F;
	Uerror("cannot happen srinc_class");
	return BAD;
}
int
srunc(int n, int m)
{	switch(m) {
	case Q_FULL_F: return n-2;
	case Q_EMPT_F: return n-2-DELTA;
	case Q_EMPT_T: return n-2-2*DELTA;
	case Q_FULL_T: return n-2-3*DELTA;
	case ALPHA_F:
	case TIMEOUT_F: return 257; /* non-zero, and > MAXQ */
	}
	Uerror("cannot happen srunc");
	return 0;
}
#endif
int cnt;
#ifdef HAS_UNLESS
int
isthere(Trans *a, int b)
{	Trans *t;
	for (t = a; t; t = t->nxt)
		if (t->t_id == b)
			return 1;
	return 0;
}
#endif
#ifndef NOREDUCE
int
mark_safety(Trans *t) /* for conditional safety */
{	int g = 0, i, j, k;

	if (!t) return 0;
	if (t->qu[0])
		return (t->qu[1])?2:1;	/* marked */

	for (i = 0; i < 2; i++)
	{	j = srinc_set(t->tpe[i]);
		if (j >= GLOBAL && j != ALPHA_F)
			return -1;
		if (j != LOCAL)
		{	k = srunc(t->tpe[i], j);
			if (g == 0
			||  t->qu[0] != k
			||  t->ty[0] != j)
			{	t->qu[g] = k;
				t->ty[g] = j;
				g++;
	}	}	}
	return g;
}
#endif
void
retrans(int n, int m, int is, short srcln[], uchar reach[], uchar lpstate[])
	/* process n, with m states, is=initial state */
{	Trans *T0, *T1, *T2, *T3;
	Trans *T4, *T5; /* t_reverse or has_unless */
	int i;
#if defined(HAS_UNLESS) || !defined(NOREDUCE)
	int k;
#endif
#ifndef NOREDUCE
	int g, h, j, aa;
#endif
#ifdef HAS_UNLESS
	int p;
#endif
	if (state_tables >= 4)
	{	printf("STEP 1 %s\n", 
			procname[n]);
		for (i = 1; i < m; i++)
		for (T0 = trans[n][i]; T0; T0 = T0->nxt)
			crack(n, i, T0, srcln);
		return;
	}
	do {
		for (i = 1, cnt = 0; i < m; i++)
		{	T2 = trans[n][i];
			T1 = T2?T2->nxt:(Trans *)0;
/* prescan: */		for (T0 = T1; T0; T0 = T0->nxt)
/* choice in choice */	{	if (T0->st && trans[n][T0->st]
				&&  trans[n][T0->st]->nxt)
					break;
			}
#if 0
		if (T0)
		printf("\tstate %d / %d: choice in choice\n",
		i, T0->st);
#endif
			if (T0)
			for (T0 = T1; T0; T0 = T0->nxt)
			{	T3 = trans[n][T0->st];
				if (!T3->nxt)
				{	T2->nxt = cpytr(T0);
					T2 = T2->nxt;
					imed(T2, T0->st, n, i);
					continue;
				}
				do {	T3 = T3->nxt;
					T2->nxt = cpytr(T3);
					T2 = T2->nxt;
					imed(T2, T0->st, n, i);
				} while (T3->nxt);
				cnt++;
			}
		}
	} while (cnt);
	if (state_tables >= 3)
	{	printf("STEP 2 %s\n", 
			procname[n]);
		for (i = 1; i < m; i++)
		for (T0 = trans[n][i]; T0; T0 = T0->nxt)
			crack(n, i, T0, srcln);
		return;
	}
	for (i = 1; i < m; i++)
	{	if (trans[n][i] && trans[n][i]->nxt) /* optimize */
		{	T1 = trans[n][i]->nxt;
#if 0
			printf("\t\tpull %d (%d) to %d\n",
			T1->st, T1->forw, i);
#endif
			srcln[i] = srcln[T1->st];	/* Oyvind Teig, 5.2.0 */

			if (!trans[n][T1->st]) continue;
			T0 = cpytr(trans[n][T1->st]);
			trans[n][i] = T0;
			reach[T1->st] = 1;
			imed(T0, T1->st, n, i);
			for (T1 = T1->nxt; T1; T1 = T1->nxt)
			{
#if 0
			printf("\t\tpull %d (%d) to %d\n",
				T1->st, T1->forw, i);
#endif
		/*		srcln[i] = srcln[T1->st];  gh: not useful */
				if (!trans[n][T1->st]) continue;
				T0->nxt = cpytr(trans[n][T1->st]);
				T0 = T0->nxt;
				reach[T1->st] = 1;
				imed(T0, T1->st, n, i);
	}	}	}
	if (state_tables >= 2)
	{	printf("STEP 3 %s\n", 
			procname[n]);
		for (i = 1; i < m; i++)
		for (T0 = trans[n][i]; T0; T0 = T0->nxt)
			crack(n, i, T0, srcln);
		return;
	}
#ifdef HAS_UNLESS
	for (i = 1; i < m; i++)
	{	if (!trans[n][i]) continue;
		/* check for each state i if an
		 * escape to some state p is defined
		 * if so, copy and mark p's transitions
		 * and prepend them to the transition-
		 * list of state i
		 */
	 if (!like_java) /* the default */
	 {	for (T0 = trans[n][i]; T0; T0 = T0->nxt)
		for (k = HAS_UNLESS-1; k >= 0; k--)
		{	if (p = T0->escp[k])
			for (T1 = trans[n][p]; T1; T1 = T1->nxt)
			{	if (isthere(trans[n][i], T1->t_id))
					continue;
				T2 = cpytr(T1);
				T2->e_trans = p;
				T2->nxt = trans[n][i];
				trans[n][i] = T2;
		}	}
	 } else /* outermost unless checked first */
	 {	T4 = T3 = (Trans *) 0;
		for (T0 = trans[n][i]; T0; T0 = T0->nxt)
		for (k = HAS_UNLESS-1; k >= 0; k--)
		{	if (p = T0->escp[k])
			for (T1 = trans[n][p]; T1; T1 = T1->nxt)
			{	if (isthere(trans[n][i], T1->t_id))
					continue;
				T2 = cpytr(T1);
				T2->nxt = (Trans *) 0;
				T2->e_trans = p;
				if (T3)	T3->nxt = T2;
				else	T4 = T2;
				T3 = T2;
		}	}
		if (T4)
		{	T3->nxt = trans[n][i];
			trans[n][i] = T4;
		}
	 }
	}
#endif
#ifndef NOREDUCE
	for (i = 1; i < m; i++)
	{	if (a_cycles)
		{ /* moves through these states are visible */
	#if PROG_LAB>0 && defined(HAS_NP)
			if (progstate[n][i])
				goto degrade;
			for (T1 = trans[n][i]; T1; T1 = T1->nxt)
				if (progstate[n][T1->st])
					goto degrade;
	#endif
			if (accpstate[n][i] || visstate[n][i])
				goto degrade;
			for (T1 = trans[n][i]; T1; T1 = T1->nxt)
				if (accpstate[n][T1->st])
					goto degrade;
		}
		T1 = trans[n][i];
		if (!T1) continue;
		g = mark_safety(T1);	/* V3.3.1 */
		if (g < 0) goto degrade; /* global */
		/* check if mixing of guards preserves reduction */
		if (T1->nxt)
		{	k = 0;
			for (T0 = T1; T0; T0 = T0->nxt)
			{	if (!(T0->atom&8))
					goto degrade;
				for (aa = 0; aa < 2; aa++)
				{	j = srinc_set(T0->tpe[aa]);
					if (j >= GLOBAL && j != ALPHA_F)
						goto degrade;
					if (T0->tpe[aa]
					&&  T0->tpe[aa]
					!=  T1->tpe[0])
						k = 1;
			}	}
			/* g = 0;	V3.3.1 */
			if (k)	/* non-uniform selection */
			for (T0 = T1; T0; T0 = T0->nxt)
			for (aa = 0; aa < 2; aa++)
			{	j = srinc_set(T0->tpe[aa]);
				if (j != LOCAL)
				{	k = srunc(T0->tpe[aa], j);
					for (h = 0; h < 6; h++)
						if (T1->qu[h] == k
						&&  T1->ty[h] == j)
							break;
					if (h >= 6)
					{	T1->qu[g%6] = k;
						T1->ty[g%6] = j;
						g++;
			}	}	}
			if (g > 6)
			{	T1->qu[0] = 0;	/* turn it off */
				printf("pan: warning, line %d, ",
					srcln[i]);
			 	printf("too many stmnt types (%d)",
					g);
			  	printf(" in selection\n");
			  goto degrade;
			}
		}
		/* mark all options global if >=1 is global */
		for (T1 = trans[n][i]; T1; T1 = T1->nxt)
			if (!(T1->atom&8)) break;
		if (T1)
degrade:	for (T1 = trans[n][i]; T1; T1 = T1->nxt)
			T1->atom &= ~8;	/* mark as unsafe */
		/* can only mix 'r's or 's's if on same chan */
		/* and not mixed with other local operations */
		T1 = trans[n][i];
		if (!T1 || T1->qu[0]) continue;
		j = T1->tpe[0];
		if (T1->nxt && T1->atom&8)
		{ if (j == 5*DELTA)
		  {	printf("warning: line %d ", srcln[i]);
			printf("mixed condition ");
			printf("(defeats reduction)\n");
			goto degrade;
		  }
		  for (T0 = T1; T0; T0 = T0->nxt)
		  for (aa = 0; aa < 2; aa++)
		  if  (T0->tpe[aa] && T0->tpe[aa] != j)
		  {	printf("warning: line %d ", srcln[i]);
			printf("[%d-%d] mixed %stion ",
				T0->tpe[aa], j, 
				(j==5*DELTA)?"condi":"selec");
			printf("(defeats reduction)\n");
			printf("	'%s' <-> '%s'\n",
				T1->tp, T0->tp);
			goto degrade;
		} }
	}
#endif
	for (i = 1; i < m; i++)
	{	T2 = trans[n][i];
		if (!T2
		||  T2->nxt
		||  strncmp(T2->tp, ".(goto)", 7)
		||  !stopstate[n][i])
			continue;
		stopstate[n][T2->st] = 1;
	}
	if (state_tables && !verbose)
	{	if (dodot)
		{	char buf[256], *q = buf, *p = procname[n];
			while (*p != '\0')
			{	if (*p != ':')
				{	*q++ = *p;
				}
				p++;
			}
			*q = '\0';
			printf("digraph ");
			switch (Btypes[n]) {
			case I_PROC:  printf("init {\n"); break;
			case N_CLAIM: printf("claim_%s {\n", buf); break;
			case E_TRACE: printf("notrace {\n"); break;
			case N_TRACE: printf("trace {\n"); break;
			default:      printf("p_%s {\n", buf); break;
			}
			printf("size=\"8,10\";\n");
			printf("  GT [shape=box,style=dotted,label=\"%s\"];\n", buf);
			printf("  GT -> S%d;\n", is);
		} else
		{	switch (Btypes[n]) {
			case I_PROC:  printf("init\n"); break;
			case N_CLAIM: printf("claim %s\n", procname[n]); break;
			case E_TRACE: printf("notrace assertion\n"); break;
			case N_TRACE: printf("trace assertion\n"); break;
			default:      printf("proctype %s\n", procname[n]); break;
		}	}
		for (i = 1; i < m; i++)
		{	reach[i] = 1;
		}
		tagtable(n, m, is, srcln, reach);
		if (dodot) printf("}\n");
	} else
	for (i = 1; i < m; i++)
	{	int nrelse;
		if (Btypes[n] != N_CLAIM)
		{	for (T0 = trans[n][i]; T0; T0 = T0->nxt)
			{	if (T0->st == i
				&& strcmp(T0->tp, "(1)") == 0)
				{	printf("error: proctype '%s' ",
						procname[n]);
		  			printf("line %d, state %d: has un",
						srcln[i], i);
					printf("conditional self-loop\n");
					pan_exit(1);
		}	}	}
		nrelse = 0;
		for (T0 = trans[n][i]; T0; T0 = T0->nxt)
		{	if (strcmp(T0->tp, "else") == 0)
				nrelse++;
		}
		if (nrelse > 1)
		{	printf("error: proctype '%s' state",
				procname[n]);
		  	printf(" %d, inherits %d", i, nrelse);
		  	printf(" 'else' stmnts\n");
			pan_exit(1);
	}	}
#if !defined(LOOPSTATE) && !defined(BFS_PAR)
	if (state_tables)
#endif
	do_dfs(n, m, is, srcln, reach, lpstate);

	if (!t_reverse)
	{	return;
	}
	/* process n, with m states, is=initial state -- reverse list */
	if (!state_tables && Btypes[n] != N_CLAIM)
	{	for (i = 1; i < m; i++)
		{	Trans *Tx = (Trans *) 0; /* list of escapes */
			Trans *Ty = (Trans *) 0; /* its tail element */
			T1 = (Trans *) 0; /* reversed list */
			T2 = (Trans *) 0; /* its tail */
			T3 = (Trans *) 0; /* remembers possible 'else' */

			/* find unless-escapes, they should go first */
			T4 = T5 = T0 = trans[n][i];
	#ifdef HAS_UNLESS
			while (T4 && T4->e_trans) /* escapes are first in orig list */
			{	T5 = T4;	  /* remember predecessor */
				T4 = T4->nxt;
			}
	#endif
			/* T4 points to first non-escape, T5 to its parent, T0 to original list */
			if (T4 != T0)		 /* there was at least one escape */
			{	T3 = T5->nxt;		 /* start of non-escapes */
				T5->nxt = (Trans *) 0;	 /* separate */
				Tx = T0;		 /* start of the escapes */
				Ty = T5;		 /* its tail */
				T0 = T3;		 /* the rest, to be reversed */
			}
			/* T0 points to first non-escape, Tx to the list of escapes, Ty to its tail */

			/* first tail-add non-escape transitions, reversed */
			T3 = (Trans *) 0;
			for (T5 = T0; T5; T5 = T4)
			{	T4 = T5->nxt;
	#ifdef HAS_UNLESS
				if (T5->e_trans)
				{	printf("error: cannot happen!\n");
					continue;
				}
	#endif
				if (strcmp(T5->tp, "else") == 0)
				{	T3 = T5;
					T5->nxt = (Trans *) 0;
				} else
				{	T5->nxt = T1;
					if (!T1) { T2 = T5; }
					T1 = T5;
			}	}
			/* T3 points to a possible else, which is removed from the list */
			/* T1 points to the reversed list so far (without escapes) */
			/* T2 points to the tail element -- where the else should go */
			if (T2 && T3)
			{	T2->nxt = T3;	/* add else */
			} else
			{	if (T3) /* there was an else, but there's no tail */
				{	if (!T1)	/* and no reversed list */
					{	T1 = T3; /* odd, but possible */
					} else		/* even stranger */
					{	T1->nxt = T3;
			}	}	}

			/* add in the escapes, to that they appear at the front */
			if (Tx && Ty) { Ty->nxt = T1; T1 = Tx; }

			trans[n][i] = T1;
			/* reversed, with escapes first and else last */
	}	}
	if (state_tables && verbose)
	{	printf("FINAL proctype %s\n", 
			procname[n]);
		for (i = 1; i < m; i++)
		for (T0 = trans[n][i]; T0; T0 = T0->nxt)
			crack(n, i, T0, srcln);
	}
}
void
imed(Trans *T, int v, int n, int j)	/* set intermediate state */
{	progstate[n][T->st] |= progstate[n][v];
	accpstate[n][T->st] |= accpstate[n][v];
	stopstate[n][T->st] |= stopstate[n][v];
	mapstate[n][j] = T->st;
}
void
tagtable(int n, int m, int is, short srcln[], uchar reach[])
{	Trans *z;

	if (is >= m || !trans[n][is]
	||  is <= 0 || reach[is] == 0)
		return;
	reach[is] = 0;
	if (state_tables)
	for (z = trans[n][is]; z; z = z->nxt)
	{	if (dodot)
			dot_crack(n, is, z);
		else
			crack(n, is, z, srcln);
	}

	for (z = trans[n][is]; z; z = z->nxt)
	{
#ifdef HAS_UNLESS
		int i, j;
#endif
		tagtable(n, m, z->st, srcln, reach);
#ifdef HAS_UNLESS
		for (i = 0; i < HAS_UNLESS; i++)
		{	j = trans[n][is]->escp[i];
			if (!j) break;
			tagtable(n, m, j, srcln, reach);
		}
#endif
	}
}

extern Trans *t_id_lkup[];

void
dfs_table(int n, int m, int is, short srcln[], uchar reach[], uchar lpstate[])
{	Trans *z;

	if (is >= m || is <= 0 || !trans[n][is])
		return;
	if ((reach[is] & (4|8|16)) != 0)
	{	if ((reach[is] & (8|16)) == 16)	/* on stack, not yet recorded */
		{	lpstate[is] = 1;
			reach[is] |= 8; /* recorded */
			if (state_tables && verbose)
			{	printf("state %d line %d is a loopstate\n", is, srcln[is]);
		}	}
		return;
	}
	reach[is] |= (4|16);	/* visited | onstack */
	for (z = trans[n][is]; z; z = z->nxt)
	{	t_id_lkup[z->t_id] = z;
#ifdef HAS_UNLESS
		int i, j;
#endif
		dfs_table(n, m, z->st, srcln, reach, lpstate);
#ifdef HAS_UNLESS
		for (i = 0; i < HAS_UNLESS; i++)
		{	j = trans[n][is]->escp[i];
			if (!j) break;
			dfs_table(n, m, j, srcln, reach, lpstate);
		}
#endif
	}
	reach[is] &= ~16; /* no longer on stack */
}
void
do_dfs(int n, int m, int is, short srcln[], uchar reach[], uchar lpstate[])
{	int i;
	dfs_table(n, m, is, srcln, reach, lpstate);
	for (i = 0; i < m; i++)
		reach[i] &= ~(4|8|16);
}
void
crack(int n, int j, Trans *z, short srcln[])
{	int i;

	if (!z) return;
	printf("	state %3d -(tr %3d)-> state %3d  ",
		j, z->forw, z->st);
	printf("[id %3d tp %3d", z->t_id, z->tpe[0]);
	if (z->tpe[1]) printf(",%d", z->tpe[1]);
#ifdef HAS_UNLESS
	if (z->e_trans)
		printf(" org %3d", z->e_trans);
	else if (state_tables >= 2)
	for (i = 0; i < HAS_UNLESS; i++)
	{	if (!z->escp[i]) break;
		printf(" esc %d", z->escp[i]);
	}
#endif
	printf("]");
	printf(" [%s%s%s%s%s] %s:%d => ",
		z->atom&6?"A":z->atom&32?"D":"-",
		accpstate[n][j]?"a" :"-",
		stopstate[n][j]?"e" : "-",
		progstate[n][j]?"p" : "-",
		z->atom & 8 ?"L":"G",
		PanSource, srcln[j]);
	for (i = 0; z->tp[i]; i++)
		if (z->tp[i] == '\n')
			printf("\\n");
		else
			putchar(z->tp[i]);
	if (verbose && z->qu[0])
	{	printf("\t[");
		for (i = 0; i < 6; i++)
			if (z->qu[i])
				printf("(%d,%d)",
				z->qu[i], z->ty[i]);
		printf("]");
	}
	printf("\n");
	fflush(stdout);
}
/* spin -a m.pml; cc -o pan pan.c; ./pan -D | dot -Tps > foo.ps; ps2pdf foo.ps */
void
dot_crack(int n, int j, Trans *z)
{	int i;

	if (!z) return;
	printf("	S%d -> S%d  [color=black", j, z->st);

	if (z->atom&6) printf(",style=dashed");
	else if (z->atom&32) printf(",style=dotted");
	else if (z->atom&8) printf(",style=solid");
	else printf(",style=bold");

	printf(",label=\"");
	for (i = 0; z->tp[i]; i++)
	{	if (z->tp[i] == '\\'
		&&  z->tp[i+1] == 'n')
		{	i++; printf(" ");
		} else
		{	putchar(z->tp[i]);
	}	}
	printf("\"];\n");
	if (accpstate[n][j]) printf("  S%d [color=red,style=bold];\n", j);
	else if (progstate[n][j]) printf("  S%d [color=green,style=bold];\n", j);
	if (stopstate[n][j]) printf("  S%d [color=blue,style=bold,shape=box];\n", j);
}

#ifdef VAR_RANGES
#define BYTESIZE	32	/* 2^8 : 2^3 = 256:8 = 32 */

typedef struct Vr_Ptr {
	char	*nm;
	uchar	vals[BYTESIZE];
	struct Vr_Ptr *nxt;
} Vr_Ptr;
Vr_Ptr *ranges = (Vr_Ptr *) 0;

void
logval(char *s, int v)
{	Vr_Ptr *tmp;

	if (v<0 || v > 255) return;
	for (tmp = ranges; tmp; tmp = tmp->nxt)
		if (!strcmp(tmp->nm, s))
			goto found;
	tmp = (Vr_Ptr *) emalloc(sizeof(Vr_Ptr));
	tmp->nxt = ranges;
	ranges = tmp;
	tmp->nm = s;
found:
	tmp->vals[(v)/8] |= 1<<((v)%8);
}

void
dumpval(uchar X[], int range)
{	int w, x, i, j = -1;

	for (w = i = 0; w < range; w++)
	for (x = 0; x < 8; x++, i++)
	{
from:		if ((X[w] & (1<<x)))
		{	printf("%d", i);
			j = i;
			goto upto;
	}	}
	return;
	for (w = 0; w < range; w++)
	for (x = 0; x < 8; x++, i++)
	{
upto:		if (!(X[w] & (1<<x)))
		{	if (i-1 == j)
				printf(", ");
			else
				printf("-%d, ", i-1);
			goto from;
	}	}
	if (j >= 0 && j != 255)
		printf("-255");
}

void
dumpranges(void)
{	Vr_Ptr *tmp;
	printf("\nValues assigned within ");
	printf("interval [0..255]:\n");
	for (tmp = ranges; tmp; tmp = tmp->nxt)
	{	printf("\t%s\t: ", tmp->nm);
		dumpval(tmp->vals, BYTESIZE);
		printf("\n");
	}
}
#endif
