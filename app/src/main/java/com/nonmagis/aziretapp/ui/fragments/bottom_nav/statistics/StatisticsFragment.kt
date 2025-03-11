package com.nonmagis.aziretapp.ui.fragments.bottom_nav.statistics

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.nonmagis.aziretapp.R
import com.nonmagis.aziretapp.databinding.FragmentStatisticsBinding
import java.util.Calendar


class StatisticsFragment : Fragment() {

    private val binding: FragmentStatisticsBinding by lazy {
        FragmentStatisticsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            (activity as AppCompatActivity).supportActionBar!!.title = "Статистика"
        }
        initPieChart()
        binding.calendarButton.setOnClickListener {
            showDatePickerDialog { selectedDate ->

            }
        }

        binding.allCities.setOnClickListener {
            showCityDialog { selectedCity ->
            }
        }


    }

    private fun showCityDialog(onCitySelected: (String) -> Unit) {
        val cities = arrayOf(
            "Все города",
            "Токмок",
            "Бишкек",
            "Ош",
            "Баткен",
            "Джалал Абад",
            "Астана"
        )

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите город")
            .setItems(cities) { _, which ->
                onCitySelected(cities[which])
            }
            .setNegativeButton("Отмена", null)
            .create()
            .show()
    }


    private fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDateSelected(formattedDate)
        }, year, month, day)

        datePickerDialog.show()
    }


    fun initPieChart() {
        // on below line we are setting user percent value,
        // setting description as enabled and offset for pie chart
        binding.pieChart.setUsePercentValues(true)
        binding.pieChart.getDescription().setEnabled(false)
        binding.pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
        binding.pieChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart
        binding.pieChart.setDrawHoleEnabled(true)
        binding.pieChart.setHoleColor(Color.WHITE)

        // on below line we are setting circle color and alpha
        binding.pieChart.setTransparentCircleColor(Color.WHITE)
        binding.pieChart.setTransparentCircleAlpha(110)

        // on  below line we are setting hole radius
        binding.pieChart.setHoleRadius(58f)
        binding.pieChart.setTransparentCircleRadius(61f)

        // on below line we are setting center text
        binding.pieChart.setDrawCenterText(true)

        // on below line we are setting
        // rotation for our pie chart
        binding.pieChart.setRotationAngle(0f)

        // enable rotation of the pieChart by touch
        binding.pieChart.setRotationEnabled(true)
        binding.pieChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
        binding.pieChart.legend.isEnabled = false
        binding.pieChart.setEntryLabelColor(Color.WHITE)
        binding.pieChart.setEntryLabelTextSize(12f)

        // on below line we are creating array list and
        // adding data to it to display in pie chart
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(70f))
        entries.add(PieEntry(20f))
        entries.add(PieEntry(10f))

        // on below line we are setting pie data set
        val dataSet = PieDataSet(entries, "Mobile OS")

        // on below line we are setting icons.
        dataSet.setDrawIcons(false)

        // on below line we are setting slice for pie
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        // add a lot of colors to list
        val colors: ArrayList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.gray))
        colors.add(resources.getColor(R.color.green))
        colors.add(resources.getColor(R.color.red))

        // on below line we are setting colors.
        dataSet.colors = colors

        // on below line we are setting pie data set
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        binding.pieChart.setData(data)

        // undo all highlights
        binding.pieChart.highlightValues(null)

        // loading chart
        binding.pieChart.invalidate()
    }


}