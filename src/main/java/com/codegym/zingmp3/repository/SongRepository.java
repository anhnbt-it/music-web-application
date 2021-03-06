package com.codegym.zingmp3.repository;
import com.codegym.zingmp3.model.Album;
import com.codegym.zingmp3.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Long> {
    Page<Song> findAllByNameContains(String name, Pageable pageable);

    Iterable<Song> findFirst5BySingerIdAndIdNot(Long singer_id, Long id);

    Page<Song> findAll(Pageable pageable);

    Iterable<Song> findAllBySingerId(Long id);

    Iterable<Song> findAllByAlbums(Album album);

    Page<Song> findAllByAlbums(Album album,Pageable pageable);

    Page<Song> findAllByStatusTrue(Pageable pageable);

    Page<Song> findAllByNameContainsOrAlbumsContainsOrSingerContains(String name, Album album, String singer, Pageable pageable);

    Page<Song> findAllByNameContainsOrAlbumsContains(String name, Album album, Pageable pageable);

    Page<Song> findAllByNameContainsOrSingerNameContains(String name, String singer, Pageable pageable);

    Optional<Song> findByNameContains(String name);

}
