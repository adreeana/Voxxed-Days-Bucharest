package com.adreeana.oneteam.delivery;

import com.adreeana.oneteam.application.PairingApplicationService;
import com.livedocumentation.GuidedTour;
import com.livedocumentation.PageController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PageController
public class PairingController {
    private final PairingApplicationService pairingService;

    public PairingController(PairingApplicationService pairingService) {
        this.pairingService = pairingService;
    }

    @GetMapping("/pairing")
    @GuidedTour(name = "Quick Developer Tour", description = "Main functionality delivery")
    public String pairing(
        @RequestParam(value = "teamName") String teamName,
        Model model
    ) {
        model.addAttribute("teamName", teamName);
        model.addAttribute("pairs", pairingService.shufflePairs(teamName));

        return "pairing";
    }
}
