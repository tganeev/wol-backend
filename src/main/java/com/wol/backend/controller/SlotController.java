package com.wol.backend.controller;

import com.wol.backend.dto.SlotCreateRequest;
import com.wol.backend.dto.SlotResponse;
import com.wol.backend.service.SlotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    public List<SlotResponse> getSlots() {
        return slotService.getAllSlots();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SlotResponse createSlot(@RequestBody SlotCreateRequest request, Principal principal) {
        // principal.getName() вернет email пользователя, так как мы так настроили JwtAuthFilter
        return slotService.createSlot(request, principal.getName());
    }
}