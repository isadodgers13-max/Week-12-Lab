package edu.cs3220.midterm.controller;

import edu.cs3220.midterm.model.Answer;
import edu.cs3220.midterm.model.Poll;
import edu.cs3220.midterm.repository.AnswerRepository;
import edu.cs3220.midterm.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PollController {

    @Autowired
    PollRepository pollRepo;

    @Autowired
    AnswerRepository answerRepo;

    // List Polls
    @GetMapping("/")
    public String listPolls(Model model) {
        model.addAttribute("polls", pollRepo.findAll());
        return "index"; // JTE or Thymeleaf page
    }

    // Create Poll (form)
    @GetMapping("/polls/create")
    public String createPollForm() {
        return "create-poll";
    }

    // Save Poll
    @PostMapping("/polls/create")
    public String createPoll(@RequestParam String question) {
        pollRepo.save(new Poll(null, question, null));
        return "redirect:/";
    }

    // Display Poll
    @GetMapping("/polls/{id}")
    public String showPoll(@PathVariable Long id, Model model) {
        Poll poll = pollRepo.findById(id).orElse(null);
        model.addAttribute("poll", poll);
        return "poll";
    }

    // Add Answer
    @PostMapping("/polls/{id}/answers")
    public String addAnswer(@PathVariable Long id, @RequestParam String text) {
        Poll poll = pollRepo.findById(id).orElse(null);
        if (poll != null) {
            Answer answer = new Answer();
            answer.setText(text);
            answer.setPoll(poll);
            answerRepo.save(answer);
        }
        return "redirect:/polls/" + id;
    }
}
