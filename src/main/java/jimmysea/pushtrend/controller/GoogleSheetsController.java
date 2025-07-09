package jimmysea.pushtrend.controller;


import jimmysea.pushtrend.service.GoogleSheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GoogleSheetsController {

    @Autowired
    private GoogleSheetsService googleSheetsService;

    @GetMapping("/read-sheet")
    public List<List<Object>> readGoogleSheet(
            @RequestParam String spreadsheetId,
            @RequestParam String range) throws IOException {
        return googleSheetsService.readSheet(spreadsheetId, range);
    }
}