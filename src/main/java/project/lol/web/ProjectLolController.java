package project.lol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.lol.lol.Match;
import project.lol.lol.MatchRepository;
import project.lol.lol.CategoryRepository;

@Controller
public class ProjectLolController {

		@Autowired
		private MatchRepository repository;
		
		@Autowired CategoryRepository crepository;
		
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}
		
		//Show match history
		@RequestMapping(value="/matchlist")
		public String matchList(Model model) {
			model.addAttribute("matches", repository.findAll());
			return "matchlist";
		}
		
		//Manual RESTful service to get all matches
		@RequestMapping(value="/matches", method = RequestMethod.GET)
		public @ResponseBody List<Match> matchListRest() {
			return (List<Match>) repository.findAll();
		}
		
		//Manual RESTful service to get match by id
		@RequestMapping(value="/match/{id}", method = RequestMethod.GET)
		public @ResponseBody Match findMatchRest(@PathVariable("id") Long matchId) {
			return repository.findOne(matchId);
		}
		
		//add a new match
		@RequestMapping(value="/add")
		public String addMatch(Model model){
			model.addAttribute("match", new Match());
			model.addAttribute("categories", crepository.findAll());
			return "addmatch";
		}
		
		//Save new match
		@RequestMapping(value="/save", method = RequestMethod.POST)
		public String save(Match match) {
			repository.save(match);
			return "redirect:matchlist"; //to make the app load into matchlist
		}
		
		//Delete a match
		@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long matchId, Model model) {
			repository.delete(matchId);
			return "redirect:../matchlist"; //../matchlist for the app to load the matchlist again
		}
}
