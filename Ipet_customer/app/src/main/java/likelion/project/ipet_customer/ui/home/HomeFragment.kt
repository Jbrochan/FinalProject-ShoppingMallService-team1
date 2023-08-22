package likelion.project.ipet_customer.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import likelion.project.ipet_customer.R
import likelion.project.ipet_customer.databinding.FragmentHomeBinding
import likelion.project.ipet_customer.ui.main.MainActivity

class HomeFragment : Fragment() {

    lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater)
        mainActivity = activity as MainActivity

        fragmentHomeBinding.run {

            // 시작 시 강아지 버튼 선택으로 지정하여 색상 변경
            buttonHomeDog.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.rose_200))

            // 좌측 상단 toggle button
            toggleButtonHome.run {
                addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
                    if (isChecked) {
                        when (checkedId) {
                            // 강아지 버튼 클릭 시
                            R.id.button_home_dog -> {
                                buttonHomeDog.setBackgroundColor(
                                    ContextCompat.getColor(
                                        mainActivity,
                                        R.color.rose_200
                                    )
                                )
                                buttonHomeCat.setBackgroundColor(
                                    ContextCompat.getColor(
                                        mainActivity,
                                        R.color.white
                                    )
                                )
                            }

                            // 고양이 버튼 클릭 시
                            R.id.button_home_cat -> {
                                buttonHomeCat.setBackgroundColor(
                                    ContextCompat.getColor(
                                        mainActivity,
                                        R.color.rose_200
                                    )
                                )
                                buttonHomeDog.setBackgroundColor(
                                    ContextCompat.getColor(
                                        mainActivity,
                                        R.color.white
                                    )
                                )
                            }
                        }
                    }
                }
            }

            // 대분류 카테고리 선택 시 UI 변경
            chipGroupHomeLcategory.run {
                buttonHomeScategory6.visibility = View.INVISIBLE

                setOnCheckedStateChangeListener { group, checkedIds ->
                    // test
                    when (this.checkedChipId) {
                        R.id.chip_home_food -> {
                            buttonHomeScategory6.visibility = View.INVISIBLE
                        }

                        R.id.chip_home_snack -> {
                            buttonHomeScategory5.visibility = View.INVISIBLE
                        }

                        R.id.chip_home_toy -> {
                            buttonHomeScategory4.visibility = View.INVISIBLE
                        }

                        R.id.chip_home_clothes -> {
                            buttonHomeScategory3.visibility = View.INVISIBLE
                        }

                        R.id.chip_home_house -> {
                            buttonHomeScategory2.visibility = View.INVISIBLE
                        }
                    }
                }
            }

            recyclerViewHomeJoint.run {
                adapter = HomeJointAdapter(mainActivity)
            }

            recyclerViewHomeBest.run {
                adapter = HomeBestAdapter(mainActivity)
            }
        }

        return fragmentHomeBinding.root
    }
}