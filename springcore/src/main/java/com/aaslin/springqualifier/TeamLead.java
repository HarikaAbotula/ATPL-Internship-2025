package com.aaslin.springqualifier;

import org.springframework.stereotype.Component;

@Component("teamLead")
public class TeamLead implements Leader {
    @Override
    public void guideTeam() {
        System.out.println("Team Lead is guiding the team.");
    }
}

