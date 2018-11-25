package com.example.kotlinspringbootdomademo.application.controller.web

import com.example.kotlinspringbootdomademo.application.input.VoteInput
import com.example.kotlinspringbootdomademo.domain.repository.VoteRepository
import com.example.kotlinspringbootdomademo.application.service.VoteApplicationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/votes")
class VoteController(
        private val voteRepository: VoteRepository,
        private val voteApplicationService: VoteApplicationService
) {

    @GetMapping("new")
    fun new(input: VoteInput): String {
        return "votes/new"
    }

    @PostMapping("")
    fun create(
            @Validated voteInput: VoteInput,
            bindingResult: BindingResult
    ): String {
        if(bindingResult.hasErrors()) {
            return "votes/new"
        }

        val id = voteApplicationService.create(voteInput)

        return "redirect:/votes/new"
    }

    @GetMapping("")
    fun index(model: Model): String {
        val votes = voteApplicationService.findAll()
        model.addAttribute("votes", votes)
        val result =
        return "votes/index"
    }

    @GetMapping("{id}")
    fun show(
            @PathVariable id: Int,
            model: Model
    ): String {
        val vote = voteApplicationService.findById(id)
        model.addAttribute("vote", vote)
        return "votes/show"
    }

    @GetMapping("{id}/edit")
    fun edit(
            @PathVariable id: Int,
            voteInput: VoteInput
    ): String {
        val vote = voteApplicationService.findById(id)

        voteInput.voter = vote.voter
        voteInput.candidate = vote.candidate

        return "votes/edit"
    }

    @PatchMapping("{id}")
    fun update(
            @PathVariable id: Int,
            @Validated voteInput: VoteInput,
            bindingResult: BindingResult
    ): String {
        if(bindingResult.hasErrors()) {
            return "votes/edit"
        }

        voteApplicationService.update(id, voteInput)

        return "redirect:/votes"
    }
    @DeleteMapping("{id}")
    fun delete(
            @PathVariable id: Int
    ): String {
        voteApplicationService.delete(id)
        return "redirect:/votes"
    }

}
