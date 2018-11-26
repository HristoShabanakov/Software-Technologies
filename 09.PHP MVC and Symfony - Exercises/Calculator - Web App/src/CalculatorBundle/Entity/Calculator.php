<?php
namespace CalculatorBundle\Entity;

class Calculator
{
    /**
     * @var float
     */
    private $leftOperand;

    /**
     * @var float
     */
    private $rightOperand;

    /**
     * @var string
     */
    private  $operator;

    /**
     * @return float
     */
    public function getLeftOperand(): ?float
    {
        return $this->leftOperand;
    }

    /**
     * @param float $leftOperand
     */
    public function setLeftOperand(float $leftOperand): void
    {
        $this->leftOperand = $leftOperand;
    }

    /**
     * @return float
     */
    public function getRightOperand(): ?float
    {
        return $this->rightOperand;
    }

    /**
     * @param float $rightOperand
     */
    public function setRightOperand(float $rightOperand): void
    {
        $this->rightOperand = $rightOperand;
    }

    /**
     * @return string
     */
    public function getOperator(): ?string
    {
        return $this->operator;
    }

    /**
     * @param string $operator
     */
    public function setOperator(string $operator): void
    {
        $this->operator = $operator;
    }

    /**
     * @return float
     */
    public function calculateResult(): ?string
    {
        $result = "Error !";
        if($this->getLeftOperand() != null && $this->getRightOperand() != null){
            switch ($this->getOperator()){
                case "+":
                    $result = $this->getLeftOperand() + $this->getrightOperand(); break;
                case "-":
                    $result = $this->getleftOperand() - $this->getrightOperand(); break;
                case "*":
                    $result = $this->getleftOperand() * $this->getrightOperand(); break;
                case "/":
                    $result = $this->getleftOperand() / $this->getrightOperand(); break;
                case "^":
                    $result = pow($this->getleftOperand(), $this->getrightOperand()); break;
            }
        }
        return $result;
    }

}