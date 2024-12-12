package main.inflearn.해싱시간파싱;

import java.util.*;
import java.util.stream.Collectors;

public class E_회장선거 {
    public static void main(String[] args) {
        String[] votes = {"bob tom", "bob park", "park bob", "luis park",
                "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"};
        int k = 3;
        String solution = solution(votes, k);
        System.out.println("solution = " + solution);
    }

    public static String solution(String[] votes, int k) {
        List<Candidate> candidateList = initVote(votes);
        List<Candidate> realCandidateList = filterRealCandidate(candidateList, k);
        List<String> receiverList = getReceiveGiftReceiver(realCandidateList);
        return receiverList.getFirst();
    }

    private static List<String> getReceiveGiftReceiver(List<Candidate> realCandidateList) {
        Map<String, Integer> voterMap = new HashMap<>();
        List<String> receiverList = new ArrayList<>();

        int max = 0;
        for (Candidate candidate : realCandidateList) {
            for (String voterName : candidate.getVoteList()) {
                int count = voterMap.getOrDefault(voterName, 0) + 1;
                voterMap.put(voterName, count);
                max = Math.max(max, count);
            }
        }

        for (String key : voterMap.keySet()) {
            if (voterMap.get(key) == max) {
                receiverList.add(key);
            }
        }

        receiverList.sort(String::compareTo);

        return receiverList;
    }

    private static List<Candidate> filterRealCandidate(List<Candidate> candidateList, int k) {
        return candidateList.stream()
                .filter(c -> c.isRealCandidate(k))
                .collect(Collectors.toList());
    }

    private static List<Candidate> initVote(String[] votes) {
        List<Candidate> candidateList = new ArrayList<>();
        for (String vote : votes) {
            String[] s = vote.split(" ");
            boolean isAlreadyExist = false;
            for (Candidate candidate : candidateList) {
                if (candidate.getName().equals(s[1])) {
                    candidate.addVote(s[0]);
                    isAlreadyExist = true;
                }
            }
            
            if (!isAlreadyExist) {
                candidateList.add(new Candidate(s[1], 1, new ArrayList<>(List.of(s[0]))));
            }
        }
        
        return candidateList;
    }

    static class Candidate {
        private String name;
        private int voteCount;
        private List<String> voteList;

        public Candidate(String name, int voteCount, List<String> voteList) {
            this.name = name;
            this.voteCount = voteCount;
            this.voteList = voteList;
        }

        public String getName() {
            return name;
        }

        private void addVote(String name) {
            voteList.add(name);
            voteCount++;
        }

        public boolean isRealCandidate(int k) {
            return voteCount >= k;
        }

        public List<String> getVoteList() {
            return voteList;
        }
    }
}
