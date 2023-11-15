package model;

public class Mood {
    public double mood;

    public long time_posted_epoch;

    public Mood() {
    }

    public Mood(double mood, long time_posted_epoch) {
        this.mood = mood;
        this.time_posted_epoch = time_posted_epoch;
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