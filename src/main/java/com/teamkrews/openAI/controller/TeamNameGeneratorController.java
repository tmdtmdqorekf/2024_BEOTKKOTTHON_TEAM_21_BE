package com.teamkrews.openAI.controller;

import com.teamkrews.openAI.service.TeamNameGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/openAI")
public class TeamNameGeneratorController {

    private final TeamNameGeneratorService teamNameGeneratorService;

    @GetMapping("/generate/teamName")
    public String generateTeamName(String seedWords) {
        return teamNameGeneratorService.generateTeamName(seedWords);
    }

    @PostMapping("/save/teamName/workspace/{workspaceId}")
    public void saveSelectedTeamName(@PathVariable Long workspaceId, @RequestBody String selectedTeamName) {
        teamNameGeneratorService.saveTeamName(workspaceId, selectedTeamName);
    }
}