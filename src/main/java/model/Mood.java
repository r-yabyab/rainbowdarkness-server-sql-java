package model;

public class Mood {
    public String mood_id;

    public double mood;

    public int timeSlept;

    public String activities;

    public String memo;

    public long time_posted_epoch;

    public String posted_by;

    // when fetching, creates id
    public Mood() {
    }

    // when retrieving from db
    public Mood(String mood_id, double mood, long time_posted_epoch, int timeSlept, String activities, String memo, String posted_by) {
        this.mood_id = mood_id;
        this.mood = mood;
        this.timeSlept = timeSlept;
        this.activities = activities;
        this.memo = memo;
        this.time_posted_epoch = time_posted_epoch;
        this.posted_by = posted_by;
    }

    public String getMood_id() {
        return mood_id;
    }

    public void setMood(double mood) {
        this.mood = mood;
    }

    public double getMood() {
        return mood;
    }
}

// fields
// _id: ObjectId('String')
// number: double
// userID: "String"
// createdAt: UTC string thing
// updatedAt: UTC string thing
// memo: String
// timeSlept: int