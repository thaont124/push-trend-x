package jimmysea.pushtrend.service;


import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GoogleSheetsService {

    @Autowired
    private Sheets sheetsService;

    public List<List<Object>> readSheet(String spreadsheetId, String range) throws IOException {
        // Gọi API để đọc dữ liệu
        ValueRange response = sheetsService.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        // Lấy dữ liệu từ response
        return response.getValues();
    }
}