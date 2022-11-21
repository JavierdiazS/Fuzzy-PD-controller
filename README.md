# Fuzzy-PD-controller

A fuzzy PD controller is a proportional-derivative controller. But in this case, it is better called as Present Error-Derivative of Present Error. It uses fuzzy logic software principles as a form of error control in industrial systems. PID controllers are widely used in automation to adjust valves and other process controls based on the accumulation of errors over time. Where a fuzzy PD controller differs from a standard PD controller is in its ability to provide more accurate results in nonlinear situations. Fuzzy systems are built on a type of programming logic that tries to deal with gray areas of process uncertainty more successfully than standard controls.

One of the problems with a fuzzy PD controller is that it can arrive at conclusions that are mutually contradictory and take no action. This requires a process of conflict resolution in the code that is commonly referred to in fuzzy systems as defuzzification. Defuzzification is done by giving certain parameters in a PD controller greater weight than others to tip the balance in a certain direction of action, and this is analogous to an adjusted gain in a standard PD controller.

The advantages that a fuzzy PD controller offers include that it can provide different response levels to non-linear variations in a system, and, at the same time, it can function as well as a standard PD controller in a system where variation is predictable. A fuzzy PD controller can also keep a system more stable. It can be weighted towards types of responses just like the gain settings on a standard PD controlled system as well.

For this project, the ranges of arm positions were previously defined, which are:

|       Name        |    Range of Positions    |
| ----------------- | ------------------------:|
| Side Shoulder     |    0.07 <= dA[0] <= 2.68 |
| Vertical Shoulder |   -1.5 <= dA[1] <= 1.02  |
| Upper Arm         |   -3.46 <= dA[2] <= 1.5  |
| Elbow of the Arm  |   -0.32 <= dA[3] <= 2.29 |
| LowerArm          |   -2.07 <= dA[4] <= 2.07 |
| Doll of the Arm   |   -1.39 <= dA[5] <= 1.39 |
| Wrist Rotor       |   -2.07 <= dA[6] <= 2.07 |

The speed ranges required to move the arm to a desired position were also defined:

|       Name        |    Range of Speed        |
| ----------------- | ------------------------:|
| Side Shoulder     |   -1.95 <= vA[0] <= 1.95 |
| Vertical Shoulder |   -1.95 <= vA[1] <= 1.95 |
| Upper Arm         |   -2.35 <= vA[2] <= 2.35 |
| Elbow of the Arm  |   -2.35 <= vA[3] <= 2.35 |
| LowerArm          |   -1.95 <= vA[4] <= 1.95 |
| Doll of the Arm   |   -1.76 <= vA[5] <= 1.76 |
| Wrist Rotor       |   -1.76 <= vA[5] <= 1.76 |

![PD](https://user-images.githubusercontent.com/75210642/203076262-792c0b2f-1dff-4bc7-902e-70a7f2fd7d6a.png)
> Diagrams of the seven fuzzy PD controller.

In this project, **Webots R2019b** was used with a pre-designed robot called **TIATGo_AP2_CD**.
The folders are structured as follows:

<details>
    <summary>:open_file_folder: Controllers</summary> 
  
          Control_Steel.java --> Main Class.
          Agente_Difuso.java  --> Here the fuzzy controller is done.
</details>

<details>
    <summary>:open_file_folder: Info</summary> 
  
          CDataTIAGo-Steel.txt --> Relevant info on position ranges and speeds.
</details>

<details>
    <summary>:open_file_folder: Protos</summary> 
  
          Supporting information for the simulation.
</details>

<details>
    <summary>:open_file_folder: Worlds</summary>
  
          The simulation.
</details>

The definition of present errors is this:

1.1.
- Present Error of Side Shoulder (Desired value - Sensed value)
- T(X<sub>1</sub>): BN/SN/Z/SP/BP

| ACRONYM |      Name        |
| ------- | ----------------:|
|   BN    |  Big Negative    |
|   SN    |  Small Negative  |
|   Z     |     Zero         |
|   SP    |  Small Positive  |
|   BP    |   Big Positive   |

- U<sub>1</sub>: [-2.61;2.61]

1.2.
- Derived from the present error of Side Shoulder (Present Error - Past Error)
- ΔT(X<sub>1</sub>): BN/SN/Z/SP/BP
- ΔU<sub>1</sub>: [-5.22;5.22]

2.1.
- Present Error of Vertical shoulder.
- T(X<sub>2</sub>): BN/SN/Z/SP/BP
- U<sub>1</sub>: [-2.52;2.52]

2.2.
- Derived from the present error of Vertical shoulder.
- ΔT(X<sub>2</sub>): BN/SN/Z/SP/BP
- ΔU<sub>2</sub>: [-5.04;5.04]

3.1.
- Present Error of Upper Arm.
- T(X<sub>2</sub>): BN/SN/Z/SP/BP
- U<sub>1</sub>: [-4.96;4.96]

3.2.
- Derived from the present error of Upper Arm.
- ΔT(X<sub>2</sub>): BN/SN/Z/SP/BP
- ΔU<sub>2</sub>: [-9.92;9.92]

4.1.
- Present Error of Elbow of the Arm.
- T(X<sub>2</sub>): BN/SN/Z/SP/BP
- U<sub>1</sub>: [-2.61;2.61]

4.2.
- Derived from the present error of Elbow of the Arm.
- ΔT(X<sub>2</sub>): BN/SN/Z/SP/BP
- ΔU<sub>2</sub>: [-5.22;5.22]

5.1.
- Present Error of Lower Arm.
- T(X<sub>2</sub>): BN/SN/Z/SP/BP
- U<sub>1</sub>: [-4.14;4.14]

5.2.
- Derived from the present error of Lower Arm.
- ΔT(X<sub>2</sub>): BN/SN/Z/SP/BP
- ΔU<sub>2</sub>: [-8.28;8.28]

6.1.
- Present Error of Doll of the Arm.
- T(X<sub>2</sub>): BN/SN/Z/SP/BP
- U<sub>1</sub>: [-2.78;2.78]

6.2.
- Derived from the present error of Doll of the Arm.
- ΔT(X<sub>2</sub>): BN/SN/Z/SP/BP
- ΔU<sub>2</sub>: [-5.56;5.56]

7.1.
- Present Error of Wrist Rotor.
- T(X<sub>2</sub>): BN/SN/Z/SP/BP
- U<sub>1</sub>: [-4.14;4.14]

7.2.
- Derived from the present error of Wrist Rotor.
- ΔT(X<sub>2</sub>): BN/SN/Z/SP/BP
- ΔU<sub>2</sub>: [-8.28;8.28]

The matrix of centers is as follows:

```java
private double[][][] MatrizDeCentros = {     { {-0.4875,-0.975,-0.975,0.975,0.4875},
                                               {-0.975,-1.4625,-0.4875,1.4625,0.975},
                                               {-1.95,-0.975,0,0.975,1.95},
                                               {-0.975,-1.4625,0.4875,1.4625,0.975},
                                               {-0.4875,-0.975,0.975,0.975,0.4875}},
                                 
                                             { {-0.4875,-0.975,-0.975,0.975,0.4875},
                                               {-0.975,-1.4625,-0.4875,1.4625,0.975},
                                               {-1.95,-0.975,0,0.975,1.95},
                                               {-0.975,-1.4625,0.4875,1.4625,0.975},
                                               {-0.4875,-0.975,0.975,0.975,0.4875}},
                                             
                                             { {-0.5875,-1.175,-1.175,1.175,0.5875},
                                               {-1.175,-1.765,-0.5875,1.765,1.175},
                                               {-2.35,-1.175,0,1.175,2.35},
                                               {-1.175,-1.765,0.5875,1.765,1.175},
                                               {-0.5875,-1.175,1.175,1.175,0.5875}},
    
                                             { {-0.5875,-1.175,-1.175,1.175,0.5875},
                                               {-1.175,-1.765,-0.5875,1.765,1.175},
                                               {-2.35,-1.175,0,1.175,2.35},
                                               {-1.175,-1.765,0.5875,1.765,1.175},
                                               {-0.5875,-1.175,1.175,1.175,0.5875}},
    
                                             { {-0.4875,-0.975,-0.975,0.975,0.4875},
                                               {-0.975,-1.4625,-0.4875,1.4625,0.975},
                                               {-1.95,-0.975,0,0.975,1.95},
                                               {-0.975,-1.4625,0.4875,1.4625,0.975},
                                               {-0.4875,-0.975,0.975,0.975,0.4875}},
    
                                             { {-0.44,-0.88,-0.88,0.88,0.44},
                                               {-0.88,-1.32,-0.44,1.32,0.88},
                                               {-1.76,-0.88,0,0.88,1.76},
                                               {-0.88,-1.32,0.44,1.32,0.88},
                                               {-0.44,-0.88,0.88,0.88,0.44}},
    
                                             { {-0.44,-0.88,-0.88,0.88,0.44},
                                               {-0.88,-1.32,-0.44, 1.32,0.88},
                                               {-1.76,-0.88,0,0.88, 1.76},
                                               {-0.88,-1.32,0.44,1.32,0.88},
                                               {-0.44,-0.88,0.88,0.88,0.44}}};
```
Finally, a total stabilization in ***10 seconds*** was obtained as a result.

![2022-11-20-14-01-24-_online-video-cutter com_](https://user-images.githubusercontent.com/75210642/203063725-55ac96a8-26e1-49a4-a968-0a9ffe99313e.gif)
> Final result applied in Webots.

## Contributing

Please feel free to use it if you are interested in fixing issues and contributing directly to the code base.

## License

Backpropagation is released under the MIT license. See the [LICENSE](/LICENSE) file for details.
