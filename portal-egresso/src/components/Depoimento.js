import React from "react";
import Accordion from '@mui/material/Accordion';
import AccordionDetails from '@mui/material/AccordionDetails';
import AccordionSummary from '@mui/material/AccordionSummary';
import Typography from '@mui/material/Typography';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import logo from "./../imgs/thumbnail.svg";

const Depoimento = (props) => {
    const [expanded, setExpanded] = React.useState(false);

    const handleChange = (panel) => (event, isExpanded) => {
        setExpanded(isExpanded ? panel : false);
    };

    return ( 
        <div className="m-4">
            <Accordion expanded={expanded === 'panel1'} onChange={handleChange('panel1')}>
                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1bh-content"
                    id="panel1bh-header"
                >
                    <div className="d-flex flex-row">
                        <div className="mr-3">
                            <img src={logo} alt="avatar" style={{height: "100px"}} />
                        </div>
                        <div className="d-flex flex-column justify-content-center">
                            <h5 className="text-center">Depoimento {props.nomeEgresso}</h5>
                        </div>
                    </div>

                </AccordionSummary>
                <AccordionDetails>
                    <Typography>
                        {props.depoimento}
                    </Typography>
                </AccordionDetails>
            </Accordion>
        </div>
    );
}
 
export default Depoimento;
