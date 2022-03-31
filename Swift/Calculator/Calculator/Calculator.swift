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
        view.backgroundColor = UIColor.black;
        
        // UI view
        let uiView = UIView(frame: CGRect(x: 50,
                                          y: 50,
                                          width: view.frame.size.width - 100,
                                          height: view.frame.size.height - 100))
        
        view.addSubview(uiView)
        
        let displayOutput = UILabel(frame: CGRect(x:70, y:70, width: view.frame.size.width - 140, height: 50))
        displayOutput.backgroundColor = UIColor.gray
        displayOutput.font = UIFont(name: "Arial", size: 28)
        displayOutput.textColor = UIColor.white
        displayOutput.textAlignment = NSTextAlignment.center
        displayOutput.text = "Calculator"
        displayOutput.adjustsFontSizeToFitWidth = true
        view.addSubview(displayOutput)
        
        
            }
}

