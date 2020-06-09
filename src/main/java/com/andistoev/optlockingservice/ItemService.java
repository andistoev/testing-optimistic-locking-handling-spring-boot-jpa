package com.andistoev.optlockingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void incrementAmount(String id, int amount) {
        Item item = itemRepository.findById(id).get();
        item.setAmount(item.getAmount() + amount);
    }

}
