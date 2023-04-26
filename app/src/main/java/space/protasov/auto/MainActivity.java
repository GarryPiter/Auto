package space.protasov.auto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button carBrandButton;
    private Button bodyPartButton;
    private Button damageTypeButton;
    private Button calculateButton;

    private String carBrand;
    private String bodyPart;
    private String damageType;

    private TextView resultTextView;

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.carBrandButton:
                // Код для открытия экрана выбора марки автомобиля
                break;
            case R.id.bodyPartButton:
                // Код для открытия экрана выбора части автомобиля
                break;
            case R.id.damageTypeButton:
                // Код для открытия экрана выбора типа урона
                break;
            case R.id.calculateButton:
                calculateRepairCost();
                break;
            default:
                break;
        }
    }

    private void calculateRepairCost() {
        // Код для расчета стоимости ремонта на основе марки автомобиля, детали кузова и типа повреждения
        // и отображаем результат в resultTextView
    }
}