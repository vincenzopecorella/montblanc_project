package com.example.appli_watch.utils

class ExercisesConstantsRepo(private val exercise: Exercise) {
    // Put here all the constants for peak tracking of different exercises

    //patternReco's constants
    //SQWATS

    val intDataSample1 = arrayOf(1.29239597175283,1.36317998714587,1.41437432388588,1.44523253253052,1.47604185063238,1.50160187622520,1.53609399353147,1.57042725777591,1.58674977101501,1.59468263278254,1.60246739736210,1.62892266679553,1.65547136468687,1.66357322077414,1.67173281525346,1.71363910328572,1.75550124226088,1.84651614041231,1.93751272578094,2.06181490716677,2.18613533450043,2.35114643106009,2.47910812269993,2.62490520176630,2.81573523425273,3.00647431003605,3.20985793817452,3.45625807287892,3.72718727636442,3.99794635218371,4.26739525289864,4.55557762005067,4.86587529343842,5.15428611999897,5.49829043873985,5.84213794896151,6.16065172162170,6.53444415728040,6.93389293684296,7.33364752590384,7.76495076382471,8.19658738067058,8.60984185975172,8.96949345343492,9.19971682223129,9.43014852779267,9.67274320820452,9.83917826793034,9.99725151845744,10.1565699154632,10.3274350045898,10.4519301370259,10.5914124685327,10.6320187661992,10.6701361415949,10.6245310507997,10.6088096849220,10.5932780777751,10.5714275428448,10.5420965968941,10.5338639817883,10.5499268179900,10.5662937768664,10.5960920158650,10.6260854979548,10.6698016389120,10.7131519766782,10.6852891296598,10.6571559135271,10.6184544885614,10.6057352279967,10.6135057172334,10.6212058136733,10.6263923280155,10.5546678704917,10.4740398411807,10.2758556212180,10.0779464076154,9.87172742191715,9.54654985604697,9.16808328308128,8.77297261128642,8.37805319080691,7.91370690894936,7.44962099184594,6.95232402894750,6.47059442307152,5.96786912664271,5.46500928533583,5.02549394912708,4.58590233598555,4.17507298974969,3.78551263442616,3.37860312902145,2.99513930506816,2.57110912190210,2.13867055676309,1.75085798157253,1.41466960896442,1.07850797338376,0.750218519490378,0.422139267665359,0.0536099828993974,-0.328525517216201,-0.719411781204510,-1.15904359862070,-1.59814898732816,-1.98881842650980,-2.42176271214852,-2.86753496239885,-3.31288014931870,-3.76439867618341,-4.22874120616857,-4.71032109562743,-5.21485133735744,-5.77505273046933,-6.33535272339523,-6.97164804297089,-7.66345933527117,-8.41547192638528,-9.16792835033236,-9.89816049285953,-10.6288337219099,-11.3669958948320,-12.0514993052803,-12.6659027441400,-13.2805070767791,-13.9182343903506,-14.4751418400087,-15.0170362345751,-15.5599113290909,-16.0895010161312,-16.5725756393985,-17.0560525970560,-17.4405834535171,-17.8249721413562,-18.1486005819011,-18.5076082707384,-18.8671957560110,-19.1772151392009,-19.4500525677687,-19.7438743036782,-20.0381065183510,-20.2968079068084,-20.5516696575424,-20.8066906395633,-21.0755198577939,-21.2920115346534,-21.4570266295394,-21.6109095465143,-21.7541782266251,-21.9322588096448,-22.1102360338966,-22.2640090362003,-22.4153449611856,-22.4661962051448,-22.5028319539818,-22.4218749933095,-22.3411600116977,-22.1950426791838,-21.8935073868023,-21.5388370508013,-21.1517727690908,-20.7649185922341,-20.2891329304453,-19.7916317775882,-19.2416673941158,-18.7021567721788,-18.1411570899886,-17.5800389519212,-17.0844220653273,-16.5888088364293,-16.1075363878497,-15.6260852347021,-15.0963516337357,-14.5663661135254,-13.9953547102404,-13.4242165999969,-12.8961661953132,-12.4444942031969,-11.9929925552010,-11.5968965657676,-11.1660205187713,-10.7350497483894,-10.2587756566124,-9.79118167806502,-9.29422588036602,-8.79744557915628,-8.34868980352575,-7.91620570706086,-7.52255231718555,-7.12938193758965,-6.72989176439369,-6.38875135465771,-6.04760446800519,-5.70910614199623,-5.33096246397852,-4.95259522904951,-4.49806452282858,-4.03594503343681,-3.54706964482376,-3.05805780349793,-2.58356426833266,-2.11447686837262,-1.63388896789785,-1.15324491389330,-0.622030067631281,-0.0907258204780019,0.463586159809358,1.02459182069178,1.58554058678381,2.15701945817891,2.71437076497365,3.28422176729255,3.85877394166532,4.43329313601651,4.99593554895073,5.55846954340570,6.11359223192470,6.66870217319143,7.17824032304941,7.65054493991335,8.10338260688276,8.55628121519643,8.95450967775787,9.32141619720926,9.65719183651286,9.99309068305262,10.2222934909136,10.4517102010702,10.6704271180012,10.8412941909113,11.0172606409274,11.1765570225498,11.3116789891034,11.4431063771682,11.5622460277143,11.6776573516225,11.7893785004603,11.9010772497086,11.9469767312848,11.9276725589183,11.9085712447476,11.8398915406550,11.7713021063083,11.7165724048983,11.6596262670258,11.5834481771023,11.5173177776414,11.4297186220885,11.3428255582866,11.2562909350059,11.1474506211301,11.0242900589435,10.8655869170797,10.6761269369987,10.4867172593494,10.2969128968764,10.1116039914459,9.92484405620399,9.72266358518714,9.52065034742644,9.30044652853068,9.04531712195455,8.79591478605170,8.51485440003172,8.23342199232009,7.95962284037843,7.68556833934363,7.42354670673109,7.17703810038326,6.94453559974178,6.71228563201067,6.46830915978212,6.27691342316653,6.08749905187923,5.92408463372870,5.71515501820244,5.50624754935611,5.28548143567433,5.07439041051434,4.89534787323635,4.71629899271176,4.55146487820056,4.40817495406177,4.26057617992453,4.10136918894029,3.91819462497924,3.73493976943007,3.54787936844974,3.34944839110571,3.14561225677744,2.93580979016473,2.72595916895344,2.48621735458605,2.24131703770505,1.99637507048360,1.75784023802110,1.54778823999592,1.35066156387346,1.15336638614932) //size = 301
//    val intDataSample1 = arrayOf(1.29239597175283,1.36317998714587,1.41437432388588,1.44523253253052,1.47604185063238,1.50160187622520,1.53609399353147,1.57042725777591,1.58674977101501,1.59468263278254,1.60246739736210,1.62892266679553,1.65547136468687,1.66357322077414,1.67173281525346,1.71363910328572,1.75550124226088,1.84651614041231,1.93751272578094,2.06181490716677,2.18613533450043,2.35114643106009,2.47910812269993,2.62490520176630,2.81573523425273,3.00647431003605,3.20985793817452,3.45625807287892,3.72718727636442,3.99794635218371,4.26739525289864,4.55557762005067,4.86587529343842,5.15428611999897,5.49829043873985,5.84213794896151,6.16065172162170,6.53444415728040,6.93389293684296,7.33364752590384,7.76495076382471,8.19658738067058,8.60984185975172,8.96949345343492,9.19971682223129,9.43014852779267,9.67274320820452,9.83917826793034,9.99725151845744,10.1565699154632,10.3274350045898,10.4519301370259,10.5914124685327,10.6320187661992,10.6701361415949,10.6245310507997,10.6088096849220,10.5932780777751,10.5714275428448,10.5420965968941,10.5338639817883,10.5499268179900,10.5662937768664,10.5960920158650,10.6260854979548,10.6698016389120,10.7131519766782,10.6852891296598,10.6571559135271,10.6184544885614,10.6057352279967,10.6135057172334,10.6212058136733,10.6263923280155,10.5546678704917,10.4740398411807,10.2758556212180,10.0779464076154,9.87172742191715,9.54654985604697,9.16808328308128,8.77297261128642,8.37805319080691,7.91370690894936,7.44962099184594,6.95232402894750,6.47059442307152,5.96786912664271,5.46500928533583,5.02549394912708,4.58590233598555,4.17507298974969,3.78551263442616,3.37860312902145,2.99513930506816,2.57110912190210,2.13867055676309,1.75085798157253,1.41466960896442,1.07850797338376,0.750218519490378,0.422139267665359,0.0536099828993974,-0.328525517216201,-0.719411781204510,-1.15904359862070,-1.59814898732816,-1.98881842650980,-2.42176271214852,-2.86753496239885,-3.31288014931870,-3.76439867618341,-4.22874120616857,-4.71032109562743,-5.21485133735744,-5.77505273046933,-6.33535272339523,-6.97164804297089,-7.66345933527117,-8.41547192638528,-9.16792835033236,-9.89816049285953,-10.6288337219099,-11.3669958948320,-12.0514993052803,-12.6659027441400,-13.2805070767791,-13.9182343903506,-14.4751418400087,-15.0170362345751,-15.5599113290909,-16.0895010161312,-16.5725756393985,-17.0560525970560,-17.4405834535171,-17.8249721413562,-18.1486005819011,-18.5076082707384,-18.8671957560110,-19.1772151392009,-19.4500525677687,-19.7438743036782,-20.0381065183510,-20.2968079068084,-20.5516696575424,-20.8066906395633,-21.0755198577939,-21.2920115346534,-21.4570266295394,-21.6109095465143,-21.7541782266251,-21.9322588096448,-22.1102360338966,-22.2640090362003,-22.4153449611856,-22.4661962051448,-22.5028319539818,-22.4218749933095,-22.3411600116977,-22.1950426791838,-21.8935073868023,-21.5388370508013,-21.1517727690908,-20.7649185922341,-20.2891329304453,-19.7916317775882,-19.2416673941158,-18.7021567721788,-18.1411570899886,-17.5800389519212,-17.0844220653273,-16.5888088364293,-16.1075363878497,-15.6260852347021,-15.0963516337357,-14.5663661135254,-13.9953547102404,-13.4242165999969,-12.8961661953132,-12.4444942031969,-11.9929925552010,-11.5968965657676,-11.1660205187713,-10.7350497483894,-10.2587756566124,-9.79118167806502,-9.29422588036602,-8.79744557915628,-8.34868980352575,-7.91620570706086,-7.52255231718555,-7.12938193758965,-6.72989176439369,-6.38875135465771,-6.04760446800519,-5.70910614199623,-5.33096246397852,-4.95259522904951,-4.49806452282858,-4.03594503343681,-3.54706964482376,-3.05805780349793,-2.58356426833266,-2.11447686837262,-1.63388896789785,-1.15324491389330,-0.622030067631281,-0.0907258204780019,0.463586159809358) //size = 301
    val GREATEST_SAMPLE_SIZE = intDataSample1.size

    val inBetweenSquatsWaitTime = 100
    val TRESHOLD_CORREl_SQUAT = 30000.0

    val PEAK_WIDTH1 = 80

    val G_CONST = 9.81

    val IntegIndexDim = arrayOf(0,0,0,0,0,0)
    val indexCorrAll = arrayOf(0,0,0,0,0,0)

    val sampleIntegAll: Array<Array<Double>> = arrayOf(intDataSample1)

    val RangeDim = arrayOf(PEAK_WIDTH1,0,0,0,0,0)
    val dimension = 1


    //DEAD BUG
    val intDataSample2 = arrayOf(-7.66885029537602,-7.75449559731613,-7.79648303565225,-7.85830343687054,-7.94061498175488,-7.85719210742264,-7.7242484455436,-7.242592015944,-6.57284259545125,-6.56882974621592,-7.05582813412538,-7.22244711209005,-7.51838279303045,-8.25574587452135,-9.06455836167518,-10.1436463332673,-11.4405286031575,-12.9495931792884,-14.8628409318905,-16.7374442421641,-18.4436274556443,-20.4790305611656,-22.2841663545204,-23.7662968045463,-25.8591474041208,-28.2248614880287,-30.3587000914656,-32.5890331794945,-34.838067642774,-36.636808685747,-37.8749396635419,-38.8292456598639,-39.8397190474425,-41.2972166263494,-43.1284772296793,-44.2431511921933,-44.4667548263623,-44.7706914262355,-45.4584382910945,-45.6157956186171,-44.9796152554419,-43.7562267983975,-42.4058998668946,-41.3459678197954,-37.9932578824409,-35.6861654611995,-34.7952207236951,-32.3177722184374,-29.2162080841834,-25.1264276812401,-23.5878670933925,-22.4086954631317,-18.3094377405056,-14.7128913076208,-12.6373684936527,-9.24991508722077,-5.60198320691903,-3.42284059180874,-1.02349401317504,2.14540362035805,5.13529035563684,7.85039277769253,10.0776830379911,12.1456888515676,14.5266870438675,16.6045343864096,18.1463213891454,19.605893047732,21.2458521576677,23.0164555641095,25.0051363058362,26.9278654950811,28.2880505642022,29.4119674571979,30.4998913969968,31.797904395858,34.2817176559551,38.3174334692957,42.1928068358342,44.8784216493979,47.2083935304228,49.7182105466353,51.9482291799116,53.3405745959982,53.796970192085,54.1803637516611,55.1170460431653,53.5675811175625,52.7754111494523,53.2171464744437,51.7212047082114,49.0474436907367,45.1590467751629,43.1613930856897,40.6051245203933,35.446622974289,31.1258897559821,27.8179266861951,22.7623655945044,17.5175545882007,13.7883162940143,10.3905605823022,6.74305092005605,3.32162474773418,0.537232210761934,-1.56345758437496,-3.57014191242813,-5.72931023105821,-7.68311433370417,-9.26647885389365,-10.1128728526861,-10.3744135444625)
    val GREATEST_SAMPLE_SIZE2 = intDataSample2.size

    val inBetweenDeadBugWaitTime = 100
    val TRESHOLD_CORREl_DeadBug = 30000.0

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
    val JJ_intDataSample2 = arrayOf(1.21630160720632,1.20540889587194,1.16678849310216,1.09380435041707,0.998140699909123,0.881297718739038,0.749394375823849,0.596704543933386,0.412911729443634,0.200561090445729,-0.0117120807363486,-0.194586527449847,-0.346752387698435,-0.483154081359707,-0.605810822159200,-0.698962490836337,-0.736165028612911,-0.702001301118678,-0.663757088711911,-0.616086689272299,-0.556493468057500,-0.512656196645681,-0.479644168809790,-0.463211551799456,-0.460623410739802,-0.471160218323503,-0.492522458718273,-0.498387113686306,-0.476272075355172,-0.459005051380404,-0.448121447871477,-0.418474424192066,-0.386467524533637,-0.368035873085288,-0.360485264554588,-0.357586829885066,-0.364585172387906,-0.409339345265180,-0.496518363675505,-0.562976848292753,-0.616973678009012,-0.655940714209213,-0.656511110940012,-0.600029340373621,-0.467123591907826,-0.280911137795708,-0.0792243951568021,0.113445616694965,0.290826933433717,0.453637739837818,0.621920299538516,0.784213946597766,0.922714169589642,1.03289650571131,1.11620821024233,1.17626711075324,1.21033105887981,1.21449417743586)
    val JJ_GREATEST_SAMPLE_SIZE = JJ_intDataSample2.size

    val inBetweenJacksWaitTime = 70

    val TRESHOLD_CORREl_JACKS = 700.0

    val JJ_PEAK_WIDTH1 = 20

    val JJ_IntegIndexDim = arrayOf(0,0,0,0,0,0)
    val JJ_indexCorrAll = arrayOf(0,0,0,0,0,0)

    val JJ_sampleIntegAll: Array<Array<Double>> = arrayOf(JJ_intDataSample2)

    val JJ_RangeDim = arrayOf(JJ_PEAK_WIDTH1,0,0,0,0,0)
    val JJ_dimension = 1


    //BIRD DOG
    val intDataSample_BD = arrayOf(57.4690334627173,64.4731026446129,72.0997598705371,80.1720696068515,86.8669968252498,91.1107596710828,93.6027756795939,93.9948924443374,91.9132696153612,87.6152283652098,82.6084930211302,77.1147038337744,70.7575226415617,64.3083409713905,58.0069132693209,51.6261766638663,45.8320144219937,40.9706490126749,36.2392062860596,30.0080774755342,23.1324523588718,16.6038526945204,8.816191738947,-5.26663627336742,-23.1714887496083,-33.6192748798522,-38.5517514054624,-43.7367248933416,-53.8898451128974,-65.2712338866152,-75.098510077413,-84.3779020299154,-93.7963858208601,-103.041445956316,-110.014833516497,-113.266685825036,-114.111146376479,-113.160720618842,-109.947713951035,-104.63025837126,-99.6429791661557,-95.1480998938201,-90.4989815881959,-86.7896115649918,-83.7128889301084,-80.7192099390453,-79.1814336699437,-78.2710375928541,-77.5915585190452,-76.6480260988015,-75.9962294854663,-74.7271336438734,-74.2850153599521,-74.6192897450348,-71.822231830367,-66.9466703150774,-60.9073985857373,-55.8426693201801,-53.7994450716138,-50.7540724955416,-44.1403118501132,-38.267280804486,-32.2957729316995,-24.7009421207747,-17.4421643299963,-13.5207263326099,-10.6006457514203,-6.40137265703984,-2.55642155454088,1.49000460134295,7.12758671704358,12.6111733588135,17.100988648946,22.8956563019384,29.0118363988922,32.3223528807124,36.5809127158828,42.7620479546181,46.2756843116945,49.4672860601384,53.565263642302,56.9668663306871,61.3653057106612,65.3588103306794,66.5023845881492,68.6068708927048,72.9594395094995,74.2797713465215,74.5025271989389,74.4192077286164,71.6662756845721,68.2064584889837,63.9770441011155,57.5172356544172,50.7410248457306,45.8491751818046,40.9503569571342,35.3807739552287,30.5287937310355,25.4838677929556,19.8171641070201,15.164397376959,12.5571258874288,9.55385325025253,6.29678020578588,6.36906050793622,5.99392046191277,3.56345736593802,4.12918411056051,5.63715096213364,6.21615765259933,5.66846080779606)
    val GREATEST_SAMPLE_SIZE_BD = intDataSample_BD.size

    val inBetweenBirdDogWaitTime = 100
    val TRESHOLD_CORREl_BirdDog = 30000.0

    val PEAK_WIDTH_BD = 366-337

    val IntegIndexDim_BD = arrayOf(0,0,0,0,0,0)
    val indexCorrAll_BD = arrayOf(0,0,0,0,0,0)


    val sampleIntegAll_BD: Array<Array<Double>> = arrayOf(intDataSample_BD)

    val RangeDim_BD = arrayOf(PEAK_WIDTH_BD,0,0,0,0,0)
    val dimension_BD = 1



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