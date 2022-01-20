package org.ricardorodrigues.socialnetwork.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ricardorodrigues.socialnetwork.dto.SubredditDto;
import org.ricardorodrigues.socialnetwork.model.Subreddit;
import org.ricardorodrigues.socialnetwork.repository.SubredditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;

   @Transactional
    public SubredditDto save(SubredditDto subredditDto){
        Subreddit save = mapSubredditDto(subredditDto);
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional
    public Subreddit mapSubredditDto(SubredditDto subredditDto) {
        return Subreddit.builder().name(subredditDto.getName())
                .description(subredditDto.getDescription())
                .build();
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
      return subredditRepository.findAll()
              .stream()
              .map(this::mapToDto)
              .collect(toList());
    }

    private SubredditDto mapToDto(Subreddit subreddit) {
        return SubredditDto.builder().name(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                .build();
    }
}
