package com.example.redditclonefinalproject.services;

import com.example.redditclonefinalproject.dtos.SubredditDto;
import com.example.redditclonefinalproject.models.Subreddit;
import com.example.redditclonefinalproject.repositories.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(mapSubredditToDto(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    private Subreddit mapSubredditToDto(SubredditDto subredditDto) {
       Subreddit subreddit = new Subreddit();
       subreddit.setName(subredditDto.getName());
       subreddit.setDescription(subredditDto.getDescription());
       return subreddit;
    }


    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
         return subredditRepository.findAll()
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }
    private SubredditDto mapToDto(Subreddit subreddit) {
        SubredditDto subredditDto = new SubredditDto();
        subredditDto.setName(subreddit.getName());
        subredditDto.setId(subreddit.getId());
        int count = 0;
        if (subreddit.getPosts() != null) count = subreddit.getPosts().size();
        subredditDto.setNumberOfPosts(count);
        return subredditDto;
    }
}
