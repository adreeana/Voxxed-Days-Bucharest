package com.adreeana.oneteam.delivery;

import com.adreeana.oneteam.application.EngineerDto;
import com.adreeana.oneteam.application.TeamApplicationService;
import com.adreeana.oneteam.application.TeamDto;
import com.livedocumentation.PageController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PageController
public class TeamController {
    private final TeamApplicationService teamService;

    public TeamController(TeamApplicationService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team")
    public String teamForm(
        Model model
    ) {
        model.addAttribute("team", new TeamDto("Voxxed Days Bucharest"));
        return "team";
    }

    @PostMapping("/team")
    public String teamSubmit(
        @ModelAttribute TeamDto team,
        Model model
    ) {
        TeamDto teamDto = teamService.addTeam(team.getName());

        model.addAttribute("team", teamDto);
        model.addAttribute("engineer", new EngineerDto());

        return "engineers";
    }

    @GetMapping("/engineers")
    public String engineersForm(
        @RequestParam(value = "teamName") String teamName,
        Model model
    ) {
        model.addAttribute("team", teamService.getTeam(teamName));
        model.addAttribute("engineer", new EngineerDto());

        return "engineers";
    }

    @PostMapping("/engineers")
    public String engineersSubmit(
        @RequestParam(value = "teamName") String teamName,
        @ModelAttribute("engineer") EngineerDto engineer,
        Model model
    ) {
        TeamDto teamDto = teamService.addEngineer(teamName, engineer.getName());

        model.addAttribute("team", teamDto);
        model.addAttribute("engineer", new EngineerDto());

        return "engineers";
    }
}
