package com.rodrigo.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddBusinessCardActivity : AppCompatActivity() {

    private val bindind by lazy {activityAddBusinessCardBinding.inflate(layoutInflater))

        private val mainViewModel: MainViewModel by viewModels {
            mainViewModelFactory((application as App).repository)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_business_card)
    }
    private fun Insertlisteners(){
        binding.btnClose.setOnClicklistener{
        finish()

            binding.btnconfirm.setOnClicklistener{
                val businessCard = BusinessCard(
                    nome = binding,tilNome.editText?.text.toString(),
                    empresa = binding,tilNome.editText?.text.toString(),
                    telefone = binding.tilTelefone.editText?.text.toString(),
                    fundoPersonalizado = binding.tilCor.editText?.text.toString()
                )
                mainViewModel.insert(businessCar

                        Toast.makeText( context:this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
                finish()

            }

        }

    }