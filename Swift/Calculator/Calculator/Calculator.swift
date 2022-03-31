//
//  Calculator.swift
//  Calculator
//
//  Created by Jonas Heuberger on 24.03.22.
//

import UIKit

class Calculator: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = UIColor.gray;
        
        let displayNum = UILabel(frame: CGRect(x:70, y:70, width: view.frame.size.width - 140, height: 50))
        
        displayNum.backgroundColor = UIColor.black
        displayNum.font = UIFont(name: "Arial", size: 28)
        displayNum.textColor = UIColor.white
        displayNum.textAlignment = NSTextAlignment.center
        displayNum.text = "label"
        displayNum.adjustsFontSizeToFitWidth = true
        
        view.addSubview(displayNum);
        
        
    }
    
}

