/* Copyright 2016 Roychoudhury, Abhishek */

package org.abhishek.utilities.databuilder.data;

/**
 * @author abhishek
 * @since 1.0
 */
public interface PersonData {
    public static final String[] FIRST_NAMES = new String[] {
        "Terry", "Eric", "Jessica", "Jason", "Dennis", "Ruth", "Stephanie", "Randy", "Norma", "Andrew", "Walter", "Melissa", "Jose", "Eugene", "Kathryn", "Ryan", "Albert", "Amy", "Tina", "Lillian",
        "Lori", "Marie", "Walter", "Charles", "Lori", "Harold", "Peter", "Paula", "Mark", "Jeffrey", "Beverly", "Amy", "Anthony", "Diane", "Earl", "Stephen", "Richard", "Gregory", "Brian", "Randy",
        "Raymond", "Jacqueline", "Aaron", "Jimmy", "Teresa", "Ernest", "Gloria", "Maria", "Karen", "Russell", "Jonathan", "Louise", "Joyce", "Virginia", "Kimberly", "Randy", "Brandon", "Helen",
        "Beverly", "Joan", "Jose", "Benjamin", "Julia", "William", "Roy", "Helen", "Anthony", "Jeremy", "Carl", "Irene", "Paul", "Cheryl", "Phyllis", "Paul", "Louis", "Mary", "Charles", "Lawrence",
        "Sara", "Brenda", "Jessica", "Harry", "Paula", "Christine", "Marilyn", "Steve", "Gregory", "Ruth", "Dennis", "Bonnie", "Frank", "Wanda", "Mary", "Lisa", "Martin", "Tammy", "Beverly",
        "Philip", "Judy", "Kenneth"
    };

    public static final String[] LAST_NAMES = new String[] {
        "Willis", "Daniels", "Garza", "Fox", "Carpenter", "Alexander", "Crawford", "Hunter", "Hughes", "Stanley", "Williams", "Thomas", "Kim", "Murray", "Moreno", "Larson", "Miller", "Weaver", "Fox",
        "Lopez", "Gibson", "Williamson", "Butler", "Stewart", "Carroll", "Hughes", "Jordan", "Wagner", "Torres", "Gibson", "Franklin", "Phillips", "Parker", "Nelson", "Morrison", "Carroll", "Mills",
        "Little", "Hunt", "Williams", "Mitchell", "Bell", "Henry", "Burns", "Harris", "Jackson", "Allen", "Tucker", "Campbell", "Hill", "Gonzales", "Carr", "Bishop", "Greene", "Olson", "Lawson",
        "Morales", "Chapman", "Simmons", "Larson", "Hamilton", "Gilbert", "Ward", "Kennedy", "Lewis", "Howard", "Adams", "Palmer", "Gutierrez", "Henderson", "Rice", "Hayes", "Murray", "Torres",
        "Carter", "Oliver", "Matthews", "Spencer", "Ortiz", "Ryan", "Ruiz", "Weaver", "Fernandez", "Frazier", "Lee", "Watkins", "Jackson", "Sims", "Parker", "Collins", "Day", "Reynolds", "Austin",
        "Oliver", "Baker", "Barnes", "Wood", "Wallace", "Mitchell", "Lopez"
    };

    public static final String[] MIDDLE_INITIALS = new String[] {
        "A", "M", "J", "K", "E", "R", "N", "D", "C", "G", "H", "S", "T", "W"
    };

    public static final String[] PREFIX = new String[] {
        "Mr", "Ms", "Mrs", "Dr"
    };

    public static final String[] SUFFIX = new String[] {
        "II", "III", "II", "IV", "Sr", "Jr"
    };

    public static final String[] GENDER = new String[] {
        "Male", "Female"
    };

    public static final String[] SSN = new String[] {
        "462-15-0253", "196-35-1987", "551-08-8245", "278-37-7884", "893-53-3098", "470-28-1679", "808-63-7313", "255-42-0049", "269-91-9344", "315-56-9856", "709-72-9170", "281-29-4332",
        "609-50-4051", "453-63-6474", "267-07-0919", "268-45-5601", "190-52-4429", "853-45-8700", "256-75-9039", "324-32-0170", "936-18-0693", "605-13-7272", "857-54-5233", "271-44-9608",
        "835-82-8077", "716-53-0213", "584-50-6067", "784-87-7167", "394-89-7655", "534-82-4320", "412-58-9624", "837-75-6696", "822-88-0617", "132-12-3669", "799-59-3886", "446-29-1978",
        "704-50-8096", "542-98-6116", "335-86-9595", "343-60-4008", "735-19-9721", "129-24-7087", "563-36-1180", "790-61-8910", "185-68-9867", "651-69-6345", "725-66-1940", "194-44-1315",
        "569-12-6646", "552-14-6727", "857-07-7828", "138-59-3911", "794-57-6351", "597-19-4490", "223-09-7934", "620-16-5537", "350-97-7753", "839-56-2337", "505-23-7003", "578-64-7912",
        "291-06-7089", "482-49-5858", "249-26-8693", "638-20-7738", "293-48-3794", "602-52-4492", "874-04-3214", "473-88-3353", "312-40-7905", "291-22-3036", "843-53-4743", "413-04-7535",
        "932-36-5558", "786-25-8747", "853-24-5662", "776-47-2423", "444-33-0962", "961-87-4791", "774-10-7687", "256-19-7721", "342-19-2352", "490-95-1351", "242-83-0877", "625-41-0775",
        "664-92-0884", "273-97-5427", "213-83-9745", "787-92-3670", "941-72-0723", "664-61-5529", "103-31-2625", "822-00-9873", "275-60-8500", "530-79-6579", "496-95-6156", "204-68-0897",
        "933-84-6773", "268-77-3643", "147-15-3911", "198-75-4107"
    };

    public static final String[] PHONE = new String[] {
        "6440847494", "7141560064", "8453255502", "8734471352", "9892520818", "3774827915", "4740636972", "3223261037", "5730062399", "7845043579", "3249073584", "6837990686", "3959831651",
        "9390914204", "8480715681", "2035362754", "3483714094", "4774721011", "9311238226", "9749779907", "4219769076", "2858967294", "4772634916", "3327845760", "9793033062", "8279250510",
        "7882675035", "2267018971", "7836838178", "2473701186", "5060539024", "5840921585", "2023063551", "3151921772", "3728719445", "4648620094", "4893579859", "2661363045", "8344947922",
        "2818558908", "7626744961", "2398911126", "5866354807", "4291477579", "2395600123", "7868192162", "7000758234", "5001538565", "8773835171", "4293944371", "9634416475", "4484068120",
        "6862907925", "9622113913", "8728682679", "2005710908", "5764805606", "5944132066", "2428362956", "3698125258", "6330812013", "8141399799", "3661051903", "3174719031", "8935741746",
        "7351450459", "2873329179", "7692114143", "5550066849", "7026187365", "2098720023", "6846957314", "8337900009", "3726362343", "8961876859", "2613461582", "5737892813", "6115930937",
        "2589673433", "6911198089", "3332043021", "3886379068", "6910224103", "9757523821", "2506003927", "7854924782", "9583999814", "8718590520", "4719861531", "5485778704", "3968889590",
        "3206368623", "5414142759", "2316386070", "2652585738", "8120296037", "9306721920", "9553644370", "3720604218", "3639656245"
    };
}
