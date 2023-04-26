package space.protasov.auto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button carBrandButton;
    private Button bodyPartButton;
    private Button damageTypeButton;
    private Button calculateButton;

    private String carBrand;
    private String bodyPart;
    private String damageType;

    private TextView resultTextView;

    // База данных для цен на ремонт в зависимости от марки авто и повреждения
    private HashMap<String, HashMap<String, Integer>> repairCostDatabase = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carBrandButton = findViewById(R.id.carBrandButton);
        bodyPartButton = findViewById(R.id.bodyPartButton);
        damageTypeButton = findViewById(R.id.damageTypeButton);
        calculateButton = findViewById(R.id.calculateButton);

        resultTextView = findViewById(R.id.resultTextView);

        carBrandButton.setOnClickListener(this);
        bodyPartButton.setOnClickListener(this);
        damageTypeButton.setOnClickListener(this);
        calculateButton.setOnClickListener(this);

        // Заполнение базы данных стоимости ремонта
        HashMap<String, Integer> toyotaRepairs = new HashMap<>();
        toyotaRepairs.put("Scratch", 200);
        toyotaRepairs.put("Dent", 300);
        toyotaRepairs.put("Broken Part", 500);
        repairCostDatabase.put("Toyota", toyotaRepairs);

        HashMap<String, Integer> bmwRepairs = new HashMap<>();
        bmwRepairs.put("Scratch", 250);
        bmwRepairs.put("Dent", 400);
        bmwRepairs.put("Broken Part", 600);
        repairCostDatabase.put("BMW", bmwRepairs);

        // Нужно добавить другие марки автомобилей и их цены на ремонт в зависимости от типа повреждения.
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.carBrandButton:
                // Код для открытия экрана выбора марки автомобиля
                Toast.makeText(this, "Выберите марку авто", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bodyPartButton:
                // Код для открытия экрана выбора части автомобиля
                Toast.makeText(this, "Выберите деталь кузова", Toast.LENGTH_SHORT).show();
                break;
            case R.id.damageTypeButton:
                // Код для открытия экрана выбора типа урона
                Toast.makeText(this, "Выберите тип повреждения", Toast.LENGTH_SHORT).show();
                break;
            case R.id.calculateButton:
                calculateRepairCost();
                break;
            default:
                break;
        }
    }

    private void calculateRepairCost() {
        if (carBrand == null || bodyPart == null || damageType == null) {
            Toast.makeText(this, "Выберите все параметры", Toast.LENGTH_SHORT).show();
            return;
        }

        // Получение цены на ремонт из базы данных
        int repairCost = repairCostDatabase.get(carBrand).get(damageType);

        // Отображение результата
        String result = "Стоимость ремонта " + carBrand + " " + bodyPart + " (" + damageType + "): " + repairCost + " руб.";
        resultTextView.setText(result);
    }
}