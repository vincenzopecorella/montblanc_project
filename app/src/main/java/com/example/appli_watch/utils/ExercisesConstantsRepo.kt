package com.example.appli_watch.utils

class ExercisesConstantsRepo(private val exercise: Exercise) {
    // Put here all the constants for peak tracking of different exercises

    val SAMPLE_FREQUENCY = 50

    //patternReco's constants
    //SQUATS

    val intDataSample1 = arrayOf(22.5668942112812,23.3600244600663,24.3094838489184,24.7362521294841,24.6584052447566,24.7536158565769,26.0018169138917,28.0437383506784,30.6757006500253,32.8699454669246,34.7197358910331,37.0076654631981,41.0005105216393,45.6025787074456,49.4214765806088,52.2389417369256,54.3743274290452,56.8087601144204,59.4058334309945,62.7799013931641,66.4200174291024,69.6709923003206,73.0028304461727,76.1294564608821,78.5381500576028,80.4244363088498,82.303977461938,84.2432862691918,85.2912377290765,85.7152298860589,86.5358339123765,87.4697311403567,88.1368132265622,88.3618840160185,87.9628160180861,86.6304770591074,84.2561486246401,81.3959762486035,77.4818694027478,72.9291984172875,69.4587815584952,66.7336403908545,64.4790307166392,61.0126073690468,55.7380448313767,48.8393290968949,41.4048299523407,33.8668255539948,26.7473674746567,19.7674771281296,12.0733781786972,3.33275422773898,-5.70231356896817,-14.9377824334091,-24.3014005688614,-32.9939559964126,-40.8847402600235,-48.923742440123,-57.8473605183548,-67.0555426148361,-75.6575752762741,-83.1145254639572,-89.8256279496139,-95.855108883757,-101.28019991197,-105.813765075583,-109.137679007429,-111.170871642012,-112.831616934914,-114.531731721539,-116.549470063824,-118.757383104939,-120.141472485442,-120.533643451113,-120.201514851827,-118.489344310541,-114.629547190446,-109.28640563466,-103.689568829316,-97.1438713786787,-89.3321696040815,-81.5714541194624,-73.7756310222334,-66.0968018291181,-57.8410182712263,-48.28573615529,-37.6334005115217,-27.2558415649122,-16.5060294387525,-6.48414213635384,1.9867612602526,9.75946323893607,17.6691185715014,24.9646058561617)
    //V2 (-23.0432026787783,-22.1002723657195,-21.1265852492844,-21.0131657481758,-21.5247676211544,-22.0308534285263,-23.5133956522456,-26.3310643260358,-30.1855014323974,-34.3035336663578,-37.8306104243911,-41.9356296240945,-45.8231147512095,-48.5341833624191,-50.6585734686184,-52.7299937515005,-55.3705171918019,-58.4977671958629,-61.7910229661399,-64.423760531944,-66.2494882711048,-67.368470504624,-68.3406534908953,-69.6731155435191,-70.6712674412705,-70.5427661072348,-70.0677088374402,-69.9952845210669,-70.0379507944102,-69.7430035236257,-69.3311347462099,-69.2915100939501,-69.2912335001061,-69.3564650498422,-69.6152504692459,-69.6002149134943,-69.2932556330333,-68.6954843853252,-67.2649058964293,-64.8009746523458,-61.5574531014668,-57.4945432354467,-53.0808017688754,-48.0271745532364,-41.7789264782538,-33.9492663257472,-25.4718306380322,-16.86304833205,-7.4501365419316,2.83133568143704,13.4358915833554,24.2035525951824,34.5404886931312,44.2540719207674,53.4772296408056,61.9856770470371,69.2888042415514,75.2303988911285,80.5866973015928,85.7609171507361,89.7038056647054,92.2747645694078,94.502328147667,97.1462185583496,99.4835679281991,100.16455549343,99.1046767375945,98.0043683818867,96.682789101412,94.096238160359,91.1809246053601,88.7117695691765,85.7995114364657,81.6242042871662,76.6585175573976,72.2495992869783,68.2227544197526,63.8854845098093,59.1075278084266,54.0618998688621,48.8944824961572,43.8486786687792,39.0755578186213,34.3559987362325,29.2936497216842,23.6206841661923,17.8804181376925,11.8672954464871,4.91663921605909,-3.14442949639873,-11.198710963767)
        //arrayOf(1.29239597175283,1.36317998714587,1.41437432388588,1.44523253253052,1.47604185063238,1.50160187622520,1.53609399353147,1.57042725777591,1.58674977101501,1.59468263278254,1.60246739736210,1.62892266679553,1.65547136468687,1.66357322077414,1.67173281525346,1.71363910328572,1.75550124226088,1.84651614041231,1.93751272578094,2.06181490716677,2.18613533450043,2.35114643106009,2.47910812269993,2.62490520176630,2.81573523425273,3.00647431003605,3.20985793817452,3.45625807287892,3.72718727636442,3.99794635218371,4.26739525289864,4.55557762005067,4.86587529343842,5.15428611999897,5.49829043873985,5.84213794896151,6.16065172162170,6.53444415728040,6.93389293684296,7.33364752590384,7.76495076382471,8.19658738067058,8.60984185975172,8.96949345343492,9.19971682223129,9.43014852779267,9.67274320820452,9.83917826793034,9.99725151845744,10.1565699154632,10.3274350045898,10.4519301370259,10.5914124685327,10.6320187661992,10.6701361415949,10.6245310507997,10.6088096849220,10.5932780777751,10.5714275428448,10.5420965968941,10.5338639817883,10.5499268179900,10.5662937768664,10.5960920158650,10.6260854979548,10.6698016389120,10.7131519766782,10.6852891296598,10.6571559135271,10.6184544885614,10.6057352279967,10.6135057172334,10.6212058136733,10.6263923280155,10.5546678704917,10.4740398411807,10.2758556212180,10.0779464076154,9.87172742191715,9.54654985604697,9.16808328308128,8.77297261128642,8.37805319080691,7.91370690894936,7.44962099184594,6.95232402894750,6.47059442307152,5.96786912664271,5.46500928533583,5.02549394912708,4.58590233598555,4.17507298974969,3.78551263442616,3.37860312902145,2.99513930506816,2.57110912190210,2.13867055676309,1.75085798157253,1.41466960896442,1.07850797338376,0.750218519490378,0.422139267665359,0.0536099828993974,-0.328525517216201,-0.719411781204510,-1.15904359862070,-1.59814898732816,-1.98881842650980,-2.42176271214852,-2.86753496239885,-3.31288014931870,-3.76439867618341,-4.22874120616857,-4.71032109562743,-5.21485133735744,-5.77505273046933,-6.33535272339523,-6.97164804297089,-7.66345933527117,-8.41547192638528,-9.16792835033236,-9.89816049285953,-10.6288337219099,-11.3669958948320,-12.0514993052803,-12.6659027441400,-13.2805070767791,-13.9182343903506,-14.4751418400087,-15.0170362345751,-15.5599113290909,-16.0895010161312,-16.5725756393985,-17.0560525970560,-17.4405834535171,-17.8249721413562,-18.1486005819011,-18.5076082707384,-18.8671957560110,-19.1772151392009,-19.4500525677687,-19.7438743036782,-20.0381065183510,-20.2968079068084,-20.5516696575424,-20.8066906395633,-21.0755198577939,-21.2920115346534,-21.4570266295394,-21.6109095465143,-21.7541782266251,-21.9322588096448,-22.1102360338966,-22.2640090362003,-22.4153449611856,-22.4661962051448,-22.5028319539818,-22.4218749933095,-22.3411600116977,-22.1950426791838,-21.8935073868023,-21.5388370508013,-21.1517727690908,-20.7649185922341,-20.2891329304453,-19.7916317775882,-19.2416673941158,-18.7021567721788,-18.1411570899886,-17.5800389519212,-17.0844220653273,-16.5888088364293,-16.1075363878497,-15.6260852347021,-15.0963516337357,-14.5663661135254,-13.9953547102404,-13.4242165999969,-12.8961661953132,-12.4444942031969,-11.9929925552010,-11.5968965657676,-11.1660205187713,-10.7350497483894,-10.2587756566124,-9.79118167806502,-9.29422588036602,-8.79744557915628,-8.34868980352575,-7.91620570706086,-7.52255231718555,-7.12938193758965,-6.72989176439369,-6.38875135465771,-6.04760446800519,-5.70910614199623,-5.33096246397852,-4.95259522904951,-4.49806452282858,-4.03594503343681,-3.54706964482376,-3.05805780349793,-2.58356426833266,-2.11447686837262,-1.63388896789785,-1.15324491389330,-0.622030067631281,-0.0907258204780019,0.463586159809358,1.02459182069178,1.58554058678381,2.15701945817891,2.71437076497365,3.28422176729255,3.85877394166532,4.43329313601651,4.99593554895073,5.55846954340570,6.11359223192470,6.66870217319143,7.17824032304941,7.65054493991335,8.10338260688276,8.55628121519643,8.95450967775787,9.32141619720926,9.65719183651286,9.99309068305262,10.2222934909136,10.4517102010702,10.6704271180012,10.8412941909113,11.0172606409274,11.1765570225498,11.3116789891034,11.4431063771682,11.5622460277143,11.6776573516225,11.7893785004603,11.9010772497086,11.9469767312848,11.9276725589183,11.9085712447476,11.8398915406550,11.7713021063083,11.7165724048983,11.6596262670258,11.5834481771023,11.5173177776414,11.4297186220885,11.3428255582866,11.2562909350059,11.1474506211301,11.0242900589435,10.8655869170797,10.6761269369987,10.4867172593494,10.2969128968764,10.1116039914459,9.92484405620399,9.72266358518714,9.52065034742644,9.30044652853068,9.04531712195455,8.79591478605170,8.51485440003172,8.23342199232009,7.95962284037843,7.68556833934363,7.42354670673109,7.17703810038326,6.94453559974178,6.71228563201067,6.46830915978212,6.27691342316653,6.08749905187923,5.92408463372870,5.71515501820244,5.50624754935611,5.28548143567433,5.07439041051434,4.89534787323635,4.71629899271176,4.55146487820056,4.40817495406177,4.26057617992453,4.10136918894029,3.91819462497924,3.73493976943007,3.54787936844974,3.34944839110571,3.14561225677744,2.93580979016473,2.72595916895344,2.48621735458605,2.24131703770505,1.99637507048360,1.75784023802110,1.54778823999592,1.35066156387346,1.15336638614932) //size = 301
//    val intDataSample1 = arrayOf(1.29239597175283,1.36317998714587,1.41437432388588,1.44523253253052,1.47604185063238,1.50160187622520,1.53609399353147,1.57042725777591,1.58674977101501,1.59468263278254,1.60246739736210,1.62892266679553,1.65547136468687,1.66357322077414,1.67173281525346,1.71363910328572,1.75550124226088,1.84651614041231,1.93751272578094,2.06181490716677,2.18613533450043,2.35114643106009,2.47910812269993,2.62490520176630,2.81573523425273,3.00647431003605,3.20985793817452,3.45625807287892,3.72718727636442,3.99794635218371,4.26739525289864,4.55557762005067,4.86587529343842,5.15428611999897,5.49829043873985,5.84213794896151,6.16065172162170,6.53444415728040,6.93389293684296,7.33364752590384,7.76495076382471,8.19658738067058,8.60984185975172,8.96949345343492,9.19971682223129,9.43014852779267,9.67274320820452,9.83917826793034,9.99725151845744,10.1565699154632,10.3274350045898,10.4519301370259,10.5914124685327,10.6320187661992,10.6701361415949,10.6245310507997,10.6088096849220,10.5932780777751,10.5714275428448,10.5420965968941,10.5338639817883,10.5499268179900,10.5662937768664,10.5960920158650,10.6260854979548,10.6698016389120,10.7131519766782,10.6852891296598,10.6571559135271,10.6184544885614,10.6057352279967,10.6135057172334,10.6212058136733,10.6263923280155,10.5546678704917,10.4740398411807,10.2758556212180,10.0779464076154,9.87172742191715,9.54654985604697,9.16808328308128,8.77297261128642,8.37805319080691,7.91370690894936,7.44962099184594,6.95232402894750,6.47059442307152,5.96786912664271,5.46500928533583,5.02549394912708,4.58590233598555,4.17507298974969,3.78551263442616,3.37860312902145,2.99513930506816,2.57110912190210,2.13867055676309,1.75085798157253,1.41466960896442,1.07850797338376,0.750218519490378,0.422139267665359,0.0536099828993974,-0.328525517216201,-0.719411781204510,-1.15904359862070,-1.59814898732816,-1.98881842650980,-2.42176271214852,-2.86753496239885,-3.31288014931870,-3.76439867618341,-4.22874120616857,-4.71032109562743,-5.21485133735744,-5.77505273046933,-6.33535272339523,-6.97164804297089,-7.66345933527117,-8.41547192638528,-9.16792835033236,-9.89816049285953,-10.6288337219099,-11.3669958948320,-12.0514993052803,-12.6659027441400,-13.2805070767791,-13.9182343903506,-14.4751418400087,-15.0170362345751,-15.5599113290909,-16.0895010161312,-16.5725756393985,-17.0560525970560,-17.4405834535171,-17.8249721413562,-18.1486005819011,-18.5076082707384,-18.8671957560110,-19.1772151392009,-19.4500525677687,-19.7438743036782,-20.0381065183510,-20.2968079068084,-20.5516696575424,-20.8066906395633,-21.0755198577939,-21.2920115346534,-21.4570266295394,-21.6109095465143,-21.7541782266251,-21.9322588096448,-22.1102360338966,-22.2640090362003,-22.4153449611856,-22.4661962051448,-22.5028319539818,-22.4218749933095,-22.3411600116977,-22.1950426791838,-21.8935073868023,-21.5388370508013,-21.1517727690908,-20.7649185922341,-20.2891329304453,-19.7916317775882,-19.2416673941158,-18.7021567721788,-18.1411570899886,-17.5800389519212,-17.0844220653273,-16.5888088364293,-16.1075363878497,-15.6260852347021,-15.0963516337357,-14.5663661135254,-13.9953547102404,-13.4242165999969,-12.8961661953132,-12.4444942031969,-11.9929925552010,-11.5968965657676,-11.1660205187713,-10.7350497483894,-10.2587756566124,-9.79118167806502,-9.29422588036602,-8.79744557915628,-8.34868980352575,-7.91620570706086,-7.52255231718555,-7.12938193758965,-6.72989176439369,-6.38875135465771,-6.04760446800519,-5.70910614199623,-5.33096246397852,-4.95259522904951,-4.49806452282858,-4.03594503343681,-3.54706964482376,-3.05805780349793,-2.58356426833266,-2.11447686837262,-1.63388896789785,-1.15324491389330,-0.622030067631281,-0.0907258204780019,0.463586159809358) //size = 301
    val GREATEST_SAMPLE_SIZE = intDataSample1.size

    val inBetweenSquatsWaitTime = 50
    val TRESHOLD_CORREl_SQUAT = 300000.0
        //V2 150000.0
        //40000.0

    val PEAK_WIDTH1 =  40 //V2 50 //80

    val G_CONST = 9.81

    val IntegIndexDim = arrayOf(0,0,0,0,0,0)
    val indexCorrAll = arrayOf(0,0,0,0,0,0)

    val sampleIntegAll: Array<Array<Double>> = arrayOf(intDataSample1)

    val RangeDim = arrayOf(PEAK_WIDTH1,0,0,0,0,0)
    val dimension = 1


    //DEAD BUG
    val intDataSample2 = arrayOf(-7.66885029537602,-7.75449559731613,-7.79648303565225,-7.85830343687054,-7.94061498175488,-7.85719210742264,-7.7242484455436,-7.242592015944,-6.57284259545125,-6.56882974621592,-7.05582813412538,-7.22244711209005,-7.51838279303045,-8.25574587452135,-9.06455836167518,-10.1436463332673,-11.4405286031575,-12.9495931792884,-14.8628409318905,-16.7374442421641,-18.4436274556443,-20.4790305611656,-22.2841663545204,-23.7662968045463,-25.8591474041208,-28.2248614880287,-30.3587000914656,-32.5890331794945,-34.838067642774,-36.636808685747,-37.8749396635419,-38.8292456598639,-39.8397190474425,-41.2972166263494,-43.1284772296793,-44.2431511921933,-44.4667548263623,-44.7706914262355,-45.4584382910945,-45.6157956186171,-44.9796152554419,-43.7562267983975,-42.4058998668946,-41.3459678197954,-37.9932578824409,-35.6861654611995,-34.7952207236951,-32.3177722184374,-29.2162080841834,-25.1264276812401,-23.5878670933925,-22.4086954631317,-18.3094377405056,-14.7128913076208,-12.6373684936527,-9.24991508722077,-5.60198320691903,-3.42284059180874,-1.02349401317504,2.14540362035805,5.13529035563684,7.85039277769253,10.0776830379911,12.1456888515676,14.5266870438675,16.6045343864096,18.1463213891454,19.605893047732,21.2458521576677,23.0164555641095,25.0051363058362,26.9278654950811,28.2880505642022,29.4119674571979,30.4998913969968,31.797904395858,34.2817176559551,38.3174334692957,42.1928068358342,44.8784216493979,47.2083935304228,49.7182105466353,51.9482291799116,53.3405745959982,53.796970192085,54.1803637516611,55.1170460431653,53.5675811175625,52.7754111494523,53.2171464744437,51.7212047082114,49.0474436907367,45.1590467751629,43.1613930856897,40.6051245203933,35.446622974289,31.1258897559821,27.8179266861951,22.7623655945044,17.5175545882007,13.7883162940143,10.3905605823022,6.74305092005605,3.32162474773418,0.537232210761934,-1.56345758437496,-3.57014191242813,-5.72931023105821,-7.68311433370417,-9.26647885389365,-10.1128728526861,-10.3744135444625)
    val GREATEST_SAMPLE_SIZE2 = intDataSample2.size

    val inBetweenDeadBugWaitTime = 120
    val TRESHOLD_CORREl_DeadBug = 80000.0

    val PEAK_WIDTH2 = 433 - 391

    val IntegIndexDim2 = arrayOf(0,0,0,0,0,0)
    val indexCorrAll2 = arrayOf(0,0,0,0,0,0)


    val sampleIntegAll2: Array<Array<Double>> = arrayOf(intDataSample2)

    val RangeDim2 = arrayOf(PEAK_WIDTH2,0,0,0,0,0)
    val dimension2 = 1


    //test for second dimension
    //var intDataSample2 = arrayOf(1.29239597175283,1.36317998714587,1.41437432388588,1.44523253253052,1.47604185063238,1.50160187622520,1.53609399353147,1.57042725777591,1.58674977101501,1.59468263278254,1.60246739736210,1.62892266679553,1.65547136468687,1.66357322077414,1.67173281525346,1.71363910328572,1.75550124226088,1.84651614041231,1.93751272578094,2.06181490716677,2.18613533450043,2.35114643106009,2.47910812269993,2.62490520176630,2.81573523425273,3.00647431003605,3.20985793817452,3.45625807287892,3.72718727636442,3.99794635218371,4.26739525289864,4.55557762005067,4.86587529343842,5.15428611999897,5.49829043873985,5.84213794896151,6.16065172162170,6.53444415728040,6.93389293684296,7.33364752590384,7.76495076382471,8.19658738067058,8.60984185975172,8.96949345343492,9.19971682223129,9.43014852779267,9.67274320820452,9.83917826793034,9.99725151845744,10.1565699154632,10.3274350045898,10.4519301370259,10.5914124685327,10.6320187661992,10.6701361415949,10.6245310507997,10.6088096849220,10.5932780777751,10.5714275428448,10.5420965968941,10.5338639817883,10.5499268179900,10.5662937768664,10.5960920158650,10.6260854979548,10.6698016389120,10.7131519766782,10.6852891296598,10.6571559135271,10.6184544885614,10.6057352279967,10.6135057172334,10.6212058136733,10.6263923280155,10.5546678704917,10.4740398411807,10.2758556212180,10.0779464076154,9.87172742191715,9.54654985604697,9.16808328308128,8.77297261128642,8.37805319080691,7.91370690894936,7.44962099184594,6.95232402894750,6.47059442307152,5.96786912664271,5.46500928533583,5.02549394912708,4.58590233598555,4.17507298974969,3.78551263442616,3.37860312902145,2.99513930506816,2.57110912190210,2.13867055676309,1.75085798157253,1.41466960896442,1.07850797338376,0.750218519490378,0.422139267665359,0.0536099828993974,-0.328525517216201,-0.719411781204510,-1.15904359862070,-1.59814898732816,-1.98881842650980,-2.42176271214852,-2.86753496239885,-3.31288014931870,-3.76439867618341,-4.22874120616857,-4.71032109562743,-5.21485133735744,-5.77505273046933,-6.33535272339523,-6.97164804297089,-7.66345933527117,-8.41547192638528,-9.16792835033236,-9.89816049285953,-10.6288337219099,-11.3669958948320,-12.0514993052803,-12.6659027441400,-13.2805070767791,-13.9182343903506,-14.4751418400087,-15.0170362345751,-15.5599113290909,-16.0895010161312,-16.5725756393985,-17.0560525970560,-17.4405834535171,-17.8249721413562,-18.1486005819011,-18.5076082707384,-18.8671957560110,-19.1772151392009,-19.4500525677687,-19.7438743036782,-20.0381065183510,-20.2968079068084,-20.5516696575424,-20.8066906395633,-21.0755198577939,-21.2920115346534,-21.4570266295394,-21.6109095465143,-21.7541782266251,-21.9322588096448,-22.1102360338966,-22.2640090362003,-22.4153449611856,-22.4661962051448,-22.5028319539818,-22.4218749933095,-22.3411600116977,-22.1950426791838)
    //val PEAK_WIDTH2 = 50
    //val sampleIntegAll: Array<Array<Double>> = arrayOf(intDataSample1)
    //val dimension = 1//1
    //val RangeDim = arrayOf(PEAK_WIDTH1,0,0,0,0,0)
    //end of test for second dim


    //squats    //to change later on
    //var dataAccAll = Array(1) { mutableListOf(0.0) }

    //Jumping jacks
//    val JJ_intDataSample2 = arrayOf(328.328050641348,331.259616915701,321.310575872529,298.85431679191,266.170271924312,226.312863272825,182.249390707415,133.01127257321,86.5502314277977,60.6785536037006,55.5034629215439,78.2357555716643,104.519027991359,112.211919101824,80.641595408419,13.972404042923,-83.1207628800353,-172.447387045212,-250.660640240072,-309.112199887993,-354.76572149727,-398.98481201838,-427.646354541048,-439.15342856668,-437.932702535446,-429.131628223774,-410.042399570636,-379.760945541442,-339.145272620521,-290.799858891139,-240.980820417338,-190.815362344677,-139.463366785645,-88.3067428171383,-25.9441185734973,53.8778355467068,110.095355240402,141.32227894815,132.532092462047,120.098723397353,109.247746614168,114.632939230838,150.653012537298,214.462422151657,268.191630123141,308.161251645796,328.719595660279,336.721405320493,339.688927351137)
    val JJ_intDataSample2 = arrayOf(-0.150950279951096,-0.150276660680771,-0.147899077177048,-0.144812571763992,-0.140443464517593,-0.136396481752396,-0.132158131837845,-0.125402943372726,-0.116547385931015,-0.107795696020126,-0.100040416955948,-0.0924567110538483,-0.0827262561321259,-0.0734776711463928,-0.0651745545864105,-0.0543217136859894,-0.0397710802555084,-0.0216733586788178,-0.00101250720024109,0.0205771639347076,0.0445537016391754,0.0704117777347565,0.0964552147388458,0.121844048738480,0.144088238000870,0.162067179918289,0.179865198373795,0.199626830339432,0.218357795953751,0.230959017992020,0.237806849241257,0.240503832817078,0.237850649833679,0.228036639332771,0.213032484531403,0.199234990596771,0.187206470727921,0.172393560171127,0.154416877985001,0.135778068780899,0.117474900484085,0.0983283607959747,0.0795348417758942,0.0607710916996002,0.0422701590061188,0.0261151354312897,0.0127578947544098,0.00236740708351135,-0.00710940313339233,-0.0163187661170959,-0.0254302773475647,-0.0357375493049622,-0.0480889673233032,-0.0620694251060486,-0.0781303794384003,-0.0975506610870361,-0.117683322429657,-0.135132197856903,-0.149497256278992)
    //1.21630160720632,1.20540889587194,1.16678849310216,1.09380435041707,0.998140699909123,0.881297718739038,0.749394375823849,0.596704543933386,0.412911729443634,0.200561090445729,-0.0117120807363486,-0.194586527449847,-0.346752387698435,-0.483154081359707,-0.605810822159200,-0.698962490836337,-0.736165028612911,-0.702001301118678,-0.663757088711911,-0.616086689272299,-0.556493468057500,-0.512656196645681,-0.479644168809790,-0.463211551799456,-0.460623410739802,-0.471160218323503,-0.492522458718273,-0.498387113686306,-0.476272075355172,-0.459005051380404,-0.448121447871477,-0.418474424192066,-0.386467524533637,-0.368035873085288,-0.360485264554588,-0.357586829885066,-0.364585172387906,-0.409339345265180,-0.496518363675505,-0.562976848292753,-0.616973678009012,-0.655940714209213,-0.656511110940012,-0.600029340373621,-0.467123591907826,-0.280911137795708,-0.0792243951568021,0.113445616694965,0.290826933433717,0.453637739837818,0.621920299538516,0.784213946597766,0.922714169589642,1.03289650571131,1.11620821024233,1.17626711075324,1.21033105887981,1.21449417743586)
    val JJ_GREATEST_SAMPLE_SIZE = JJ_intDataSample2.size

    val inBetweenJacksWaitTime = 30//70

    val TRESHOLD_CORREl_JACKS = 500.0
        //3000.0

    val JJ_PEAK_WIDTH1 = 40 //20

    val JJ_IntegIndexDim = arrayOf(0,0,0,0,0,0)
    val JJ_indexCorrAll = arrayOf(0,0,0,0,0,0)

    val JJ_sampleIntegAll: Array<Array<Double>> = arrayOf(JJ_intDataSample2)

    val JJ_RangeDim = arrayOf(JJ_PEAK_WIDTH1,0,0,0,0,0)
    val JJ_dimension = 1


    //BIRD DOG
    val intDataSample_BD = arrayOf(57.4690334627173,64.4731026446129,72.0997598705371,80.1720696068515,86.8669968252498,91.1107596710828,93.6027756795939,93.9948924443374,91.9132696153612,87.6152283652098,82.6084930211302,77.1147038337744,70.7575226415617,64.3083409713905,58.0069132693209,51.6261766638663,45.8320144219937,40.9706490126749,36.2392062860596,30.0080774755342,23.1324523588718,16.6038526945204,8.816191738947,-5.26663627336742,-23.1714887496083,-33.6192748798522,-38.5517514054624,-43.7367248933416,-53.8898451128974,-65.2712338866152,-75.098510077413,-84.3779020299154,-93.7963858208601,-103.041445956316,-110.014833516497,-113.266685825036,-114.111146376479,-113.160720618842,-109.947713951035,-104.63025837126,-99.6429791661557,-95.1480998938201,-90.4989815881959,-86.7896115649918,-83.7128889301084,-80.7192099390453,-79.1814336699437,-78.2710375928541,-77.5915585190452,-76.6480260988015,-75.9962294854663,-74.7271336438734,-74.2850153599521,-74.6192897450348,-71.822231830367,-66.9466703150774,-60.9073985857373,-55.8426693201801,-53.7994450716138,-50.7540724955416,-44.1403118501132,-38.267280804486,-32.2957729316995,-24.7009421207747,-17.4421643299963,-13.5207263326099,-10.6006457514203,-6.40137265703984,-2.55642155454088,1.49000460134295,7.12758671704358,12.6111733588135,17.100988648946,22.8956563019384,29.0118363988922,32.3223528807124,36.5809127158828,42.7620479546181,46.2756843116945,49.4672860601384,53.565263642302,56.9668663306871,61.3653057106612,65.3588103306794,66.5023845881492,68.6068708927048,72.9594395094995,74.2797713465215,74.5025271989389,74.4192077286164,71.6662756845721,68.2064584889837,63.9770441011155,57.5172356544172,50.7410248457306,45.8491751818046,40.9503569571342,35.3807739552287,30.5287937310355,25.4838677929556,19.8171641070201,15.164397376959,12.5571258874288,9.55385325025253,6.29678020578588,6.36906050793622,5.99392046191277,3.56345736593802,4.12918411056051,5.63715096213364,6.21615765259933,5.66846080779606)
    val GREATEST_SAMPLE_SIZE_BD = intDataSample_BD.size

    val inBetweenBirdDogWaitTime = 120 //TODO
    val TRESHOLD_CORREl_BirdDog = 220000.0 //TODO


    val PEAK_WIDTH_BD = 366-337

    val IntegIndexDim_BD = arrayOf(0,0,0,0,0,0)
    val indexCorrAll_BD = arrayOf(0,0,0,0,0,0)


    val sampleIntegAll_BD: Array<Array<Double>> = arrayOf(intDataSample_BD)

    val RangeDim_BD = arrayOf(PEAK_WIDTH_BD,0,0,0,0,0)
    val dimension_BD = 1

    // LUNGES
    val intDataSample_L = arrayOf(-48.7405934542109,-44.4529704263274,-39.4198147897767,-34.5692766000385,-30.7864855462326,-27.6684552242267,-25.0709951506667,-23.453081848558,-22.8110340873083,-22.7041913462689,-22.3244866892324,-21.0453443394149,-19.9159808804432,-18.6421698111303,-16.4661334013477,-13.1079132547684,-8.85353504670744,-4.02369314791384,0.704621603243631,4.62210403306423,7.27981914432463,8.75009276616644,9.73331136209215,11.0319091601634,13.2666639803069,16.4785226722588,20.2637922641596,24.0504874217148,27.3186492017331,29.6850614486518,31.3066858206106,32.4651671721032,33.4077703981115,34.7076158082931,36.3836597791824,38.3190810236013,40.5861115606705,43.1009001163446,44.9908117355042,45.5558023757086,44.9252969566802,43.3867978278288,41.5373019196494,39.9339868000883,38.8082046327835,37.5927729019291,35.5500413878377,32.5961956814062,29.1869795663613,26.4434384074182,24.4347801961594,22.956962284788,21.6547701616319,20.7708865237343,20.3882636549044,20.6216055079695,21.6936723126505,23.6729654467261,26.6069820977368,29.6541769955532,32.2411187208814,33.7768712532006,34.1042455534197,34.1123887756677,33.9677533894626,33.6967482042506,33.463740430039,32.711227315204,31.2178169107424,29.6654790823627,27.7220064302405,24.6485253838471,20.9542329740343,17.9835962383969,16.3351406447662,15.6859337891319,15.0142324966065,13.9862227222865,13.114287442709,12.315252942198,11.0159946278851,8.54211114480617,5.27093903849817,1.88160553576818,-1.3662427746872,-4.06213085736216,-6.28771737085619,-7.98992520515922,-9.6714737361937,-11.791152219991,-14.4412707515995,-17.4206471961989,-20.5662458839735,-23.865331697084,-27.2536016038981,-30.9704780344386,-35.0094056830405,-39.0262365832531,-42.4438736199992,-44.7470816026751,-45.8033911474582,-46.4528224112628,-47.2546119079137,-47.6876723498002,-47.5611565335823,-46.6966359944609,-45.6411687367598,-44.9109480946657,-44.8037321990178,-45.5680194736807,-47.1681347189474,-49.6104810885443,-52.8309551840907,-56.377449799796,-59.4264274572765,-61.1649713193006,-61.0610947893569,-58.8635500873538)
        //-11.0812745204917,-15.6212688833145,-19.363872735376,-22.5205179775815,-24.5456087651266,-25.9261711570536,-26.7794321445617,-27.4399632690478,-28.1327428679281,-29.0150455867256,-30.1579378889208,-31.4723169466484,-32.990429230249,-34.8964177441895,-36.8428960875232,-38.6047746997898,-39.7856286016557,-40.5386325381681,-40.4079781543281,-39.8696384778085,-40.2325575250714,-41.598214129746,-42.4424092908903,-41.9950738410024,-40.7701440877638,-39.833268342897,-39.2629671935107,-38.2908332780528,-36.2640550485266,-33.1143507350067,-29.4781490111746,-26.9424839467453,-26.3921497683572,-26.4180729703075,-26.2669816091817,-26.544724218797,-27.1614754517372,-27.4281008619897,-26.8524476435688,-25.4254301153293,-23.2997924868749,-20.4304693574087,-16.6904524763424,-12.4542704578226,-8.05850237074002,-3.42043942070909,1.3538810708181,6.45826220465072,11.3178823240382,15.8978306358407,19.7044440915133,23.0076673631904,26.2940175362692,29.7723173134596,33.3350097010594,37.2753991154787,41.5778241679544,45.9716090932907,49.930903674618,53.1382153221802,55.3819587288497,56.8921212597284,57.367409741129,57.5887236708893,58.7250137298568,60.8585174759175,62.5485065151199,62.7693975847415,61.7111863820867,60.3420023712411,58.5675948002805,55.7620331342,51.5895907307017,46.3998612339906,40.9494723531976,35.4445618293311,29.4905777229848,22.5281163650194,14.6647561356014,7.33373629696878,1.87003369398068,-0.749135779604616,-0.488650182689039,1.6759960907774,4.03723268383152,4.88791719865008,3.47560835060355,0.583662030627437,-3.2376870445755,-7.94766006531088,-12.9973547364465)
        //arrayOf(-39.6484739199888,-32.2290456094085,-25.2215595197697,-20.0501711983467,-16.6981998299349,-14.6501610284989,-13.821242725587,-13.5132761658361,-13.0747782383593,-12.2811462171469,-11.5216320308479,-11.1465973821182,-11.270536315815,-11.8923805851412,-12.4012693050156,-12.1979106681846,-11.1906787694373,-9.75045255228916,-8.31200260725175,-7.10484506423925,-6.29262761953148,-6.34500193638059,-7.39904600056971,-8.97570135577754,-10.2033464034566,-10.4262517244863,-9.28443680492679,-7.06043501603787,-4.91815233327947,-4.40560891241856,-5.5460000361965,-7.12101682992126,-8.02091892136092,-8.03048040204317,-7.74188972102309,-7.86588881802464,-8.75825245568556,-10.4857520694398,-12.7944591514694,-15.085315608753,-16.8187782831479,-17.7656488654861,-18.2060253994126,-18.5362806302204,-18.8754693391783,-19.2899677565999,-19.948951377419,-20.662332748396,-21.8328317331503,-23.4248422244268,-24.9414924291742,-25.8018501665222,-26.0163075520097,-26.2639821326765,-27.2949678440692,-29.3860899713591,-32.5833602372442,-34.0749761867954,-34.1069309665136,-34.2734408915065,-35.7422268482728,-39.9269375076412,-45.6649395685969,-50.0878558949817,-51.0907259735828,-47.9411939740816,-42.194330236132,-36.3463888614041,-31.8200460448077,-29.2336694799158,-27.7100053638732,-26.1138229800054,-23.4380008954842,-19.6404062335189,-15.6105487447144,-12.0776364290739,-9.16048484936728,-6.54440256310792,-3.22593878068855,1.0925146831104,5.9337635228731,10.8742724624487,15.8534434155944,20.6895590933311,25.6244078681499,30.9324395825345,36.7748059470846,40.7220503956655,43.2411020507252,46.0447029811353,50.3526797858282,57.2613694632804,65.8112704190652,73.4150378403741,77.9395846630294,78.5976783927113,76.6522811129279,74.0225116743765,72.0875782397017,71.603313868369,71.7294150165405,70.9330939747487,68.0376532418865,63.2864110052452,57.6966138006063,51.9381608144788,46.0869968127163,39.7468761904015,32.2621655718123,23.5165747350607,13.8696513887566,3.78104980398767)
    val GREATEST_SAMPLE_SIZE_L = intDataSample_L.size

    val inBetweenLungesWaitTime = 100 //TODO
    val TRESHOLD_CORREl_L = 60000.0
        //30000.0

    val PEAK_WIDTH_L = 70 //173-130
        //366-337

    val IntegIndexDim_L = arrayOf(0,0,0,0,0,0)
    val indexCorrAll_L = arrayOf(0,0,0,0,0,0)


    val sampleIntegAll_L: Array<Array<Double>> = arrayOf(intDataSample_L)

    val RangeDim_L = arrayOf(PEAK_WIDTH_L,0,0,0,0,0)
    val dimension_L = 1

    // SITUPS
    val intDataSample_ST = arrayOf(-44.7730201241639,-43.2263331639219,-40.4365313957814,-32.0618532700791,-19.7537375316566,-5.84430280788586,6.34566774134442,17.6881014635015,28.8639314661501,37.5667561981857,43.9582780583465,45.7118327675591,44.0217098067476,42.5483438038181,40.2778559967847,38.1940188288774,34.8387360446655,32.5434736709909,37.8597005267455,48.8943646575743,64.2282266408815,81.0816755444958,100.710551853831,124.283190202437,139.134005900554,140.740494826145,126.497345285322,99.8985535195801,64.7520842301776,16.5142451835036,-40.0544182627627,-99.8468808322906,-145.31379346177,-174.013233737028,-190.909980591304,-190.850213948667,-171.690655045408,-139.020170127105,-109.677361113837,-86.5850817563231,-67.9415262320105,-57.4153842658539,-52.074574466419,-43.8593601182399,-29.9316304254478,-14.1627252821761,0.73631867412035,14.6143919533582,30.129646655313,42.7596385594045,46.1321171496755,42.9661674892992,39.67032925357,38.2822808889925,31.5008533586776,22.1649631217027,18.3979765404775,18.6013539043578,16.7333617038791,12.9409571570916,10.8088826656276,8.90294719324059,4.84978377423339,2.18200726185921,3.23031411340731,4.93139105396372,6.08530881017817,7.83522993606994,12.0284536107942,16.6459499447203,20.0690012867234,23.9548165493887,28.7213593540521,32.6677073565727,33.949094627305,33.7416881198955,32.4555215353829,28.9333039065873,23.7042107655869,17.854075873923,11.9282774927899,4.9055128198271,-2.50790683017869,-8.58326106623992,-14.7956730718574,-21.7782136690589,-28.2365871239496,-32.2001351478887,-34.4252824398356,-37.7829966163216,-40.9616087853065,-41.8251210447682,-42.2239019002254,-45.8855132650412,-52.5193697594645)
    val GREATEST_SAMPLE_SIZE_ST = intDataSample_ST.size

    val inBetweenSitupsWaitTime = 100 //TODO
    val TRESHOLD_CORREl_ST = 120000.0 //TODO

    val PEAK_WIDTH_ST = 5

    val IntegIndexDim_ST = arrayOf(0,0,0,0,0,0)
    val indexCorrAll_ST = arrayOf(0,0,0,0,0,0)


    val sampleIntegAll_ST: Array<Array<Double>> = arrayOf(intDataSample_ST)

    val RangeDim_ST = arrayOf(PEAK_WIDTH_L,0,0,0,0,0)
    val dimension_ST = 1


    public fun getConstantsExercise(): MutableList<Any> {
        if(exercise == Exercise.SQUAT){
            return mutableListOf(sampleIntegAll, inBetweenSquatsWaitTime, TRESHOLD_CORREl_SQUAT, RangeDim, dimension, IntegIndexDim, indexCorrAll, RangeDim.max(), GREATEST_SAMPLE_SIZE)
        }
        if(exercise == Exercise.DEAD_BUG){
            return mutableListOf(sampleIntegAll2, inBetweenDeadBugWaitTime, TRESHOLD_CORREl_DeadBug, RangeDim2, dimension2, IntegIndexDim2, indexCorrAll2, RangeDim2.max(), GREATEST_SAMPLE_SIZE2)
        }
        if(exercise == Exercise.JUMPING_JACK){
            return mutableListOf(JJ_sampleIntegAll, inBetweenJacksWaitTime, TRESHOLD_CORREl_JACKS, JJ_RangeDim, JJ_dimension, JJ_IntegIndexDim, JJ_indexCorrAll, JJ_RangeDim.max(), JJ_GREATEST_SAMPLE_SIZE)
        }
        if(exercise == Exercise.BIRD_DOG){
            return mutableListOf(sampleIntegAll_BD, inBetweenBirdDogWaitTime, TRESHOLD_CORREl_BirdDog, RangeDim_BD, dimension_BD, IntegIndexDim_BD, indexCorrAll_BD, RangeDim_BD.max(), GREATEST_SAMPLE_SIZE_BD)
        }
        if(exercise == Exercise.LUNGES){
            return mutableListOf(sampleIntegAll_L, inBetweenLungesWaitTime, TRESHOLD_CORREl_L, RangeDim_L, dimension_L, IntegIndexDim_L, indexCorrAll_L, RangeDim_L.max(), GREATEST_SAMPLE_SIZE_L)
        }
        if(exercise == Exercise.SITUPS){
            return mutableListOf(sampleIntegAll_ST, inBetweenSitupsWaitTime, TRESHOLD_CORREl_ST, RangeDim_ST, dimension_ST, IntegIndexDim_ST, indexCorrAll_ST, RangeDim_ST.max(), GREATEST_SAMPLE_SIZE_ST)
        }

        return mutableListOf(0f, 0f, 0f, 0f, 0f)


    }
    /*
    public fun getConstantsExercise(): MutableList<Any> {
        if(exercise == Exercise.SQUAT){
            return mutableListOf(corrDataSample, inBetweenSquatsWaitTime, TRESHOLD_CORREl_SQUAT, PEAK_WIDTH, G_CONST)
        }
        return mutableListOf(0f, 0f, 0f, 0f, 0f)
    }
    */
}