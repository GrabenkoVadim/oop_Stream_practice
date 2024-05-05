package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int MINIMUM_AGE = 35;
    private static String NATIONALITY = "Ukrainian";
    private static int PERIOD_IN_UKRAIN = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MINIMUM_AGE
                && getPeriodInUkraine(candidate) >= PERIOD_IN_UKRAIN && candidate.isAllowedToVote();
    }

    public int getPeriodInUkraine(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
